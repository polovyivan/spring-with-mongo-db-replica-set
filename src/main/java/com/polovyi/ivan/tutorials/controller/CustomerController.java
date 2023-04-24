package com.polovyi.ivan.tutorials.controller;


import com.polovyi.ivan.tutorials.dto.CustomerRequest;
import com.polovyi.ivan.tutorials.dto.CustomerResponse;
import com.polovyi.ivan.tutorials.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void getCreateCustomer(@RequestBody CustomerRequest customerRequest) {
        customerService.createCustomer(customerRequest);
    }

}
