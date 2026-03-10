package com.workshop.model.repository;

import com.workshop.model.entity.FrontDerailleur;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontDerailleurRepository extends PagingAndSortingRepository<FrontDerailleur, Long>, JpaSpecificationExecutor<FrontDerailleur> {
}
