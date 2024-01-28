package com.service.basket.controller;

import com.service.basket.model.Product;
import com.service.basket.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("{barcodeId}")
    public ResponseEntity<Product> getProductByBarcodeId(@PathVariable(name = "barcodeId") String barcodeId) {
        return ResponseEntity.ok(productService.getProductByBarcodeId(barcodeId));
    }

}
