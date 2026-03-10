package com.workshop.model.repository;

import com.workshop.model.entity.Business;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BusinessRepository extends CrudRepository<Business, Long> {

    Optional<Business> findByCompanyName(String companyName);

    boolean existsByCompanyName(String companyName);
}