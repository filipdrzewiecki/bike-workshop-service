package com.workshop.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.workshop.model.entity.Pedals;
import org.springframework.stereotype.Repository;

@Repository
public interface PedalsRepository extends PagingAndSortingRepository<Pedals, Long> {

}
