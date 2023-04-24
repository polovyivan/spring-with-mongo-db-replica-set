package com.polovyi.ivan.tutorials.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private String phoneNumber;

    private String fullName;

    private String address;

    private LocalDate createdAt;
}
