package com.zurum.flywayredisfeignclientexample.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class CustomerRequest {

    private String customerName;
    private BigDecimal customerBalance;
    private LocalDateTime creationTime;
    private LocalDate dob;
}
