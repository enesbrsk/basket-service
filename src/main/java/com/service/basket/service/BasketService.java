package com.service.basket.service;

import com.service.basket.dto.UserDto;
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
    private final UserService userService;

    public BasketService(BasketRepository basketRepository, ProductService productService, UserService userService) {
        this.basketRepository = basketRepository;
        this.productService = productService;
        this.userService = userService;
    }

    public List<Basket> getAllBasketByUserId() {
        UserDto userDto = userService.findUserInContext();

        return basketRepository.findByUserId(userDto.getId());
    }

    public Basket getBasketById(Long id) {
        return basketRepository.findById(id).orElseThrow(notFoundProduct(HttpStatus.NOT_FOUND));
    }

    public Basket createBasket(BasketRequest basketRequest) {
        Product product = productService.getProductByBarcodeId(basketRequest.getBarcodeId());
        UserDto userDto = userService.findUserInContext();

        Basket basket = basketRepository.findByBarcodeIdAndUserId(basketRequest.getBarcodeId(),userDto.getId());
        if (basket == null){

            basket = Basket.builder()
                    .userId(userDto.getId())
                    .brand(product.getBrand())
                    .productName(product.getProductName())
                    .quantity(1)
                    .totalPrice(product.getPrice())
                    .barcodeId(basketRequest.getBarcodeId())
                    .build();

        }else{
            basket = Basket.builder()
                    .quantity(basket.getQuantity()+1)
                    .totalPrice(basket.getTotalPrice()+product.getPrice())
                    .build();
        }

        return basketRepository.save(basket);
    }

    public Boolean removeProductFromBasket(String barcodeId){

        UserDto userDto = userService.findUserInContext();
        Basket basket = basketRepository.findByBarcodeIdAndUserId(barcodeId,userDto.getId());
        Product product = productService.getProductByBarcodeId(barcodeId);

        if (basket.getQuantity().equals(1)){
            basketRepository.deleteByBarcodeIdAndUserId(barcodeId,userDto.getId());
        }else{
            basket = Basket.builder()
                    .quantity(basket.getQuantity()-1)
                    .totalPrice(basket.getTotalPrice()-product.getPrice())
                    .build();

            basketRepository.save(basket);
        }

        return true;
    }

    private static Supplier<GenericException> notFoundProduct(HttpStatus notFound) {
        return () -> GenericException.builder().httpStatus(notFound).errorMessage("Product not found in basket!").build();
    }

}
