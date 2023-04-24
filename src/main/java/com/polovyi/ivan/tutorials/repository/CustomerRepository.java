package com.polovyi.ivan.tutorials.repository;

import com.polovyi.ivan.tutorials.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

}
