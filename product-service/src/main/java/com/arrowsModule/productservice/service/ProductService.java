package com.arrowsModule.productservice.service;

import com.arrowsModule.productservice.dto.ProductRequest;
import com.arrowsModule.productservice.dto.ProductResponse;
import com.arrowsModule.productservice.model.Product;
import com.arrowsModule.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product "+ product.getId() +" is saved");
    }

    public List<ProductResponse> getAllProducts() {
         List<Product> products = productRepository.findAll();
         return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
