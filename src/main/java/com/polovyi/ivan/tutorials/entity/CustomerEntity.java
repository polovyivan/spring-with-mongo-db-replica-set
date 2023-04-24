package com.polovyi.ivan.tutorials.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("customer")
public class CustomerEntity {

    @MongoId
    private String id;

    private String phoneNumber;

    private String fullName;

    private String address;

    private LocalDate createdAt;

}