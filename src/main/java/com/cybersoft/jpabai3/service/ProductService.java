package com.cybersoft.jpabai3.service;


import com.cybersoft.jpabai3.dto.request.CreateProductRequest;
import com.cybersoft.jpabai3.dto.request.UpdateProductRequest;
import com.cybersoft.jpabai3.dto.response.ProductResponse;
import com.cybersoft.jpabai3.entity.product.CategoryEntity;
import com.cybersoft.jpabai3.entity.product.ProductEntity;
import com.cybersoft.jpabai3.repository.CategoryRepository;
import com.cybersoft.jpabai3.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productEntity -> {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(productEntity.getId());
            productResponse.setName(productEntity.getName());
            productResponse.setDescription(productEntity.getDescription());
            productResponse.setPrice(productEntity.getPrice());
            return productResponse;
        }).toList();
    }

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        CategoryEntity categoryEntity = categoryRepository.findById(createProductRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(createProductRequest.getName());
        productEntity.setDescription(createProductRequest.getDescription());
        productEntity.setPrice(createProductRequest.getPrice());
        productEntity.setStock(createProductRequest.getStock());
        productEntity.setCategory(categoryEntity);
        productRepository.save(productEntity);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productEntity.getId());
        productResponse.setName(productEntity.getName());
        productResponse.setDescription(productEntity.getDescription());
        productResponse.setPrice(productEntity.getPrice());
        return productResponse;
    }

    public ProductResponse findById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productEntity.getId());
        productResponse.setName(productEntity.getName());
        productResponse.setDescription(productEntity.getDescription());
        productResponse.setPrice(productEntity.getPrice());
        return productResponse;

    }

    public ProductResponse updateProduct(Long id, UpdateProductRequest updateProductRequest) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        CategoryEntity categoryEntity = categoryRepository.findById(updateProductRequest.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        productEntity.setName(updateProductRequest.getName());
        productEntity.setDescription(updateProductRequest.getDescription());
        productEntity.setPrice(updateProductRequest.getPrice());
        productEntity.setCategory(categoryEntity);
        productRepository.save(productEntity);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(productEntity.getId());
        productResponse.setName(productEntity.getName());
        productResponse.setDescription(productEntity.getDescription());
        productResponse.setPrice(productEntity.getPrice());
        return productResponse;

    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
