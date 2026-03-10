package com.workshop.service;

import com.workshop.model.entity.PartView;
import com.workshop.model.repository.BasicPartRepository;
import com.workshop.model.repository.PartSearchRepository;
import com.workshop.model.specification.PartSpec;
import com.workshop.model.enums.PartType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.workshop.model.entity.BicyclePart;
import com.workshop.model.repository.BicyclePartRepository;

import com.workshop.model.specification.PartQuerySpecification;

import jakarta.persistence.EntityNotFoundException;

import static com.workshop.model.specification.PartSpecifications.PART_SPEC_MAP;
import static com.workshop.utils.PartNamingUtils.createProductId;
import static com.workshop.utils.SerializationUtils.deserializeEntity;

/** Manages official parts */

@Service
@RequiredArgsConstructor
public class OfficialPartService {

    private final BicyclePartRepository bicyclePartRepository;
    private final PartSearchRepository partSearchRepository;
    private final BasicPartRepository basicPartRepository;

    @Transactional
    public Page<PartView> getOfficialParts2(PartQuerySpecification querySpec, Pageable pageable) {
//        PartSpec partSpec = PART_SPEC_MAP.get(querySpec.getPartType());
        return basicPartRepository.findAll(pageable);
    }

    @SneakyThrows
    @Transactional
    public <T> Page<T> getOfficialParts(PartQuerySpecification querySpec, Pageable pageable) {
        PartSpec partSpec = PART_SPEC_MAP.get(querySpec.getPartType());
        return partSearchRepository.findAll(partSpec, querySpec, pageable);
    }

    @SneakyThrows
    @Transactional
    public BicyclePart addPart(PartType type, String partJson) {

        PartSpec spec = PART_SPEC_MAP.get(type);

        Class<?> clazz = spec.getClazz();
        BicyclePart part = (BicyclePart) deserializeEntity(partJson, clazz);

        String productId = createProductId(part);
        part.setProductId(productId);
        part.setId(null);
        part.setProduct(type.getCommonName());
        part.setIsOfficial(true);

        return bicyclePartRepository.save(part);
    }

    public Object getPart(PartType type, String id) {
        return bicyclePartRepository.findByProductId(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Couldn't find part of type %s and if %s", type.getCommonName(), id)));
    }
}
