package com.webage.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.webage.domain.Purchase;

//  PART 5b
//  Alter this interface to extend CrudRepository<Purchase, Long> 
//  REMOVE (or comment out) all methods defined within this interface.
//  They are not needed anymore; Spring Data JPA will provide the methods for us.

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}