package com.workshop.model.repository;

import com.workshop.model.entity.BottomBracket;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BottomBracketRepository extends PagingAndSortingRepository<BottomBracket, Long>, JpaSpecificationExecutor<BottomBracket> {
}
