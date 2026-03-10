package com.workshop.model.repository;

import com.workshop.model.entity.Business;
import com.workshop.model.entity.Shop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends CrudRepository<Shop, Long> {

    List<Shop> findAllByBusiness(Business business);

    Optional<Shop> findByNameAndBusiness(String name, Business business);

    boolean existsByNameAndBusiness(String name, Business business);
}