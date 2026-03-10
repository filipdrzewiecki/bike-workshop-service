package com.workshop.model.repository;

import com.workshop.model.entity.Headset;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeadsetRepository extends PagingAndSortingRepository<Headset, Long>, JpaSpecificationExecutor<Headset> {
    Optional<Headset> findByProductId (String productId);

}
