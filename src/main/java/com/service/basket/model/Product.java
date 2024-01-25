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
public class Product extends BaseEntity{

    private String barcodeId;
    private String expiryDate;
    private String brand;
    private String productName;
    private double price;

}
