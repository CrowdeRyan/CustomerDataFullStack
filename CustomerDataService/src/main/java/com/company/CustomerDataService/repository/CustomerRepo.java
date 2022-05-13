package com.company.CustomerDataService.repository;

import com.company.CustomerDataService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

    List<Customer>  findByLevel(String level);

    List<Customer> findByState(String state);
}
