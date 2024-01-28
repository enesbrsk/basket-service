package com.service.basket.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileInformation extends BaseEntity{

    private Long userId;
    private String moneyPoint;
    private LocalDateTime lastOperationDate;
    private String lastOperationLocation;
    private Double lastOperationTotalPrice;

}
