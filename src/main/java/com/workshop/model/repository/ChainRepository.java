package com.workshop.model.repository;

import com.workshop.model.entity.Chain;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainRepository extends PagingAndSortingRepository<Chain, Long>, JpaSpecificationExecutor<Chain> {
}
