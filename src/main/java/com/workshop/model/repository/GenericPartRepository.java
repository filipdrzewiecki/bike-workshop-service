package com.workshop.model.repository;

import com.workshop.model.entity.BicyclePart;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericPartRepository extends PagingAndSortingRepository<BicyclePart, Long>, JpaSpecificationExecutor<BicyclePart> {
}
