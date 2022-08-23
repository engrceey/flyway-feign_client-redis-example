package com.zurum.flywayredisfeignclientexample.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    private String customerName;
    private String email;
    private BigDecimal customerBalance;
    private LocalDateTime creationTime;
    private LocalDate dob;
}
