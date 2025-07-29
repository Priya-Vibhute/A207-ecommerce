package com.learn.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learn.ecommerce.entities.Address;

@RepositoryRestResource(path = "address")
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
