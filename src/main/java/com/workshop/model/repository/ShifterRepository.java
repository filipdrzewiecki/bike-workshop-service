package com.workshop.model.repository;

import com.workshop.model.entity.Shifter;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShifterRepository extends PagingAndSortingRepository<Shifter, Long>, JpaSpecificationExecutor<Shifter> {
}
