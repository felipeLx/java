package com.partyFind.app.repository;

import com.partyFind.app.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByBusinessName(String businessName);
    public List<Customer> findByBusinessType(String businessType);
    public Customer findByNeighborhood(String neighborhood);
    public Customer findByCity(String city);

}
