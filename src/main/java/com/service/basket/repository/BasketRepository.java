package com.service.basket.repository;

import com.service.basket.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket,Long> {

    List<Basket> findByUserId(Long userId);
    Basket findByBarcodeIdAndUserId(String barcodeId,Long userId);
    void deleteByBarcodeIdAndUserId(String barcodeId,Long userId);

}
