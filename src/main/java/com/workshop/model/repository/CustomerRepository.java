package com.workshop.model.repository;


import org.springframework.data.repository.CrudRepository;
import com.workshop.model.entity.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
