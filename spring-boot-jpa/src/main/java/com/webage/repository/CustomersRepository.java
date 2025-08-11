package com.webage.repository;

import org.springframework.data.repository.CrudRepository;

import com.webage.domain.Customer;

//  PART 5a
//  Alter this interface to extend CrudRepository<Customer, Long> 

public interface CustomersRepository extends CrudRepository<Customer, Long>
{
}
