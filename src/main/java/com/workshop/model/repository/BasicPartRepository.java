package com.workshop.model.repository;

import com.workshop.model.entity.PartView;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BasicPartRepository extends PagingAndSortingRepository<PartView, Long>, JpaSpecificationExecutor<PartView> {
}
