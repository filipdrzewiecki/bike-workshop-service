package com.workshop.model.repository;

import com.workshop.model.entity.Stem;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StemRepository extends PagingAndSortingRepository<Stem, Long>, JpaSpecificationExecutor<Stem> {
}
