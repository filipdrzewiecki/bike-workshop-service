package com.workshop.model.repository;

import com.workshop.model.entity.Chainring;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainringRepository extends PagingAndSortingRepository<Chainring, Long>, JpaSpecificationExecutor<Chainring> {
}
