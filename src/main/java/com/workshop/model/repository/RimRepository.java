package com.workshop.model.repository;

import com.workshop.model.entity.Rim;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RimRepository extends PagingAndSortingRepository<Rim, Long>, JpaSpecificationExecutor<Rim> {
}
