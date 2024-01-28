package com.service.basket.controller;


import com.service.basket.dto.request.BasketRequest;
import com.service.basket.model.Basket;
import com.service.basket.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping
    public ResponseEntity<List<Basket>> getAllBasket() {
        return ResponseEntity.ok(basketService.getAllBasketByUserId());
    }

    @PostMapping
    public ResponseEntity<Basket> createBasket(@RequestBody BasketRequest basketRequest) {
        return ResponseEntity.ok(basketService.createBasket(basketRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> removeProductFromBasket(@PathVariable String id) {
        return ResponseEntity.ok(basketService.removeProductFromBasket(id));
    }

}
