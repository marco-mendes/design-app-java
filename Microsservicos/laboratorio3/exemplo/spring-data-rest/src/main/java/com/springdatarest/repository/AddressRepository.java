package com.springdatarest.repository;

import com.springdatarest.model.Address;
import org.springframework.data.repository.CrudRepository;


public interface AddressRepository extends CrudRepository<Address, Long> {

}
