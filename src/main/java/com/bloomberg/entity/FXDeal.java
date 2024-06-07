package com.bloomberg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fx_deals", uniqueConstraints = {@UniqueConstraint(columnNames = "deal_id")})

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FXDeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true, name = "deal_unique_id")
    private String dealUniqueId;

    @NotNull
    @Size(min = 3, max = 3)
    @Column(nullable = false, name = "from_currency_iso_code")
    private String fromCurrencyIsoCode;

    @NotNull
    @Size(min = 3, max = 3)
    @Column(nullable = false, name = "to_currency_iso_code")
    private String toCurrencyIsoCode;

    @NotNull
    @Column(nullable = false, name = "deal_timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dealTimestamp;

    @NotNull
    @Positive
    @Column(nullable = false, name = "deal_amount")
    private BigDecimal dealAmount;


}
