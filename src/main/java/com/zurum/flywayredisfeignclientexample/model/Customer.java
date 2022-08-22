package com.zurum.flywayredisfeignclientexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "id_string")
    private String idString;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_balance")
    private BigDecimal customerBalance;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "date_of_birth")
    private LocalDate dob;

    @PrePersist
    protected void onCreate() {
        if (Objects.isNull(creationTime))
            this.creationTime = LocalDateTime.now();

        if (StringUtils.isBlank(this.idString))
            this.idString = RandomStringUtils.randomAlphabetic(10).toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Customer customer)) return false;

        return new EqualsBuilder().append(getCustomerId(), customer.getCustomerId()).append(getIdString(), customer.getIdString()).append(getCustomerName(), customer.getCustomerName()).append(getCustomerBalance(), customer.getCustomerBalance()).append(getCreationTime(), customer.getCreationTime()).append(getDob(), customer.getDob()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCustomerId()).append(getIdString()).append(getCustomerName()).append(getCustomerBalance()).append(getCreationTime()).append(getDob()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("customerId", customerId)
                .append("idString", idString)
                .append("customerName", customerName)
                .append("customerBalance", customerBalance)
                .append("creationTime", creationTime)
                .append("dob", dob)
                .toString();
    }
}
