package com.service.basket.service;

import com.service.basket.enums.ErrorCode;
import com.service.basket.exception.GenericException;
import com.service.basket.model.Product;
import com.service.basket.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Supplier;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        // Servis ilk ayağa kalktığında çalışacak kodlar buraya gelecek
        addDemoProducts();
    }

    private void addDemoProducts() {
        productRepository.save(new Product("123456789", "2024-12-31", "Ülker", "Dido", 5.99));
        productRepository.save(new Product("987654321", "2024-11-30", "Eti", "Gofret", 3.49));
        productRepository.save(new Product("567890123", "2024-10-31", "Sütaş", "Yoğurt", 50.79));
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(notFoundProduct(HttpStatus.NOT_FOUND));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }


    private static Supplier<GenericException> notFoundProduct(HttpStatus notFound) {
        return () -> GenericException.builder().httpStatus(notFound).errorMessage("Product not found!").build();
    }

}
