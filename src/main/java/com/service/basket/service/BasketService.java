package com.service.basket.service;

import com.service.basket.dto.request.BasketRequest;
import com.service.basket.exception.GenericException;
import com.service.basket.model.Basket;
import com.service.basket.model.Product;
import com.service.basket.repository.BasketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;

    public BasketService(BasketRepository basketRepository, ProductService productService) {
        this.basketRepository = basketRepository;
        this.productService = productService;
    }

    public List<Basket> getAllBasket() {
        return basketRepository.findAll();
    }

    public Basket getBasketById(Long id) {
        return basketRepository.findById(id).orElseThrow(notFoundProduct(HttpStatus.NOT_FOUND));
    }

    public Basket createBasket(BasketRequest basketRequest) {
        Product product = productService.getProductByBarcodeId(basketRequest.barcodeId());
        Basket basket = new Basket();
        Basket.builder()
                .brand(product.getBrand())
                .productName(basket.getProductName())
                .quantity(1)
                .totalPrice(product.getPrice())
                .build();

        return basketRepository.save(basket);
    }

    public Boolean removeProductFromBasket(Long id){

        Basket basket = getBasketById(id);

        if (basket.getQuantity() < 1){
            notFoundProduct(HttpStatus.NOT_FOUND);
        }

        basketRepository.deleteById(id);
        return true;
    }

    private static Supplier<GenericException> notFoundProduct(HttpStatus notFound) {
        return () -> GenericException.builder().httpStatus(notFound).errorMessage("Product not found in basket!").build();
    }

}
