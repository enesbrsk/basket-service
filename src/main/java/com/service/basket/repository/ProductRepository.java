package com.service.basket.repository;

import com.service.basket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByBarcodeId(String barcodeId);
}
