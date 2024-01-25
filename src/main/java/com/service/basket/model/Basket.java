package com.service.basket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket extends BaseEntity{

    private String brand;
    private String productName;
    private double totalPrice;
    private Integer quantity;

}
