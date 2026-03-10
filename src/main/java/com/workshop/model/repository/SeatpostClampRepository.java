package com.workshop.model.repository;

import com.workshop.model.entity.SeatpostClamp;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatpostClampRepository extends PagingAndSortingRepository<SeatpostClamp, Long>, JpaSpecificationExecutor<SeatpostClamp> {
}
