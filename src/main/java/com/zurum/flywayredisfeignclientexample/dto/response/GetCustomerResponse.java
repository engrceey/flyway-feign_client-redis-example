package com.zurum.flywayredisfeignclientexample.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCustomerResponse {
    private String customerName;
    private BigDecimal customerBalance;
    private LocalDateTime creationTime;
    private LocalDate dob;
}
