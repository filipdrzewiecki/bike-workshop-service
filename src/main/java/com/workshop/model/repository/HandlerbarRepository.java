package com.workshop.model.repository;

import com.workshop.model.entity.Handlebar;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HandlerbarRepository extends PagingAndSortingRepository<Handlebar, Long>, JpaSpecificationExecutor<Handlebar> {
}
