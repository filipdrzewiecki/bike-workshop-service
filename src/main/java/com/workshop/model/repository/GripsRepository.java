package com.workshop.model.repository;

import com.workshop.model.entity.Grips;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GripsRepository extends PagingAndSortingRepository<Grips, Long>, JpaSpecificationExecutor<Grips> {
}
