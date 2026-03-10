package com.workshop.model.repository;

import com.workshop.model.entity.BrakeRotor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscRepository extends PagingAndSortingRepository<BrakeRotor, Long>, JpaSpecificationExecutor<BrakeRotor> {
}
