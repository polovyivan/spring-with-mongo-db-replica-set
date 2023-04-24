package com.polovyi.ivan.tutorials.service;

import com.polovyi.ivan.tutorials.dto.CustomerRequest;
import com.polovyi.ivan.tutorials.dto.CustomerResponse;
import com.polovyi.ivan.tutorials.entity.CustomerEntity;
import com.polovyi.ivan.tutorials.repository.CustomerRepository;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

   private final CustomerRepository customerRepository;

    //private final MongoTemplate mongoTemplate;

    public List<CustomerResponse> getAllCustomers() {
        log.info("Getting all customers...");
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(customerRepository.findAll().iterator(), Spliterator.ORDERED),
                false).map(CustomerResponse::valueOf).collect(Collectors.toList());
    }

    public void createCustomer(CustomerRequest customerRequest) {
        log.info("Creating customer...");
        customerRepository.save(CustomerEntity.builder()
                .id(UUID.randomUUID().toString())
                .phoneNumber(customerRequest.getPhoneNumber())
                .fullName(customerRequest.getFullName())
                .address(customerRequest.getAddress())
                .createdAt(customerRequest.getCreatedAt())
                .build());
    }
}

