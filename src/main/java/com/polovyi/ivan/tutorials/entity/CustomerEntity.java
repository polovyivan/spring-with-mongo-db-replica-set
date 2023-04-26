package com.polovyi.ivan.tutorials.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("customer")
public class CustomerEntity {

    @Id
    private String id;

    private String phoneNumber;

    private String fullName;

    private String address;

    private LocalDate createdAt;

}