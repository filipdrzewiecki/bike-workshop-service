package com.workshop.model.repository;

import com.workshop.model.entity.RearDerailleur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RearDerailleurRepository extends JpaRepository<RearDerailleur, Long>, JpaSpecificationExecutor<RearDerailleur> {
}
