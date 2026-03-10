package com.workshop.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.workshop.model.entity.BicyclePart;

import java.util.List;
import java.util.Optional;

@Repository
public interface BicyclePartRepository extends JpaRepository<BicyclePart, Long>, JpaSpecificationExecutor<BicyclePart> {

    Optional<BicyclePart> findByProductId (String productId);

    // For db backup in test only
    List<BicyclePart> findAllByIsOfficialTrueAndProduct(String product);

    List<BicyclePart> findAllByIsOfficialTrue();


}
