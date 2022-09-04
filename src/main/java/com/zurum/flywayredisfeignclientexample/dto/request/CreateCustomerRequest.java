package com.zurum.flywayredisfeignclientexample.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zurum.flywayredisfeignclientexample.utils.CustomLocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest implements Serializable {
    @NotBlank(message = "customer name cannot be blank")
    private String customerName;

    @Email(message = "please provide a valid email")
    private String email;

    private BigDecimal customerBalance;

    @NotNull
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate dob;
}
