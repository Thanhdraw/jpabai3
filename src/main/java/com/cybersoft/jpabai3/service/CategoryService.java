package com.cybersoft.jpabai3.service;

import com.cybersoft.jpabai3.dto.request.CreateCategoryRequest;
import com.cybersoft.jpabai3.dto.request.ProductInCategoryRequest;
import com.cybersoft.jpabai3.dto.response.ProductResponse;
import com.cybersoft.jpabai3.entity.product.CategoryEntity;
import com.cybersoft.jpabai3.entity.product.ProductEntity;
import com.cybersoft.jpabai3.repository.CategoryRepository;
import com.cybersoft.jpabai3.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public void createCategory(CreateCategoryRequest request) {
        CategoryEntity category = new CategoryEntity();
        category.setName(request.getName());
        categoryRepository.save(category);
    }

    public void createProduct(Long CategoryId, ProductInCategoryRequest request) {
        CategoryEntity category = categoryRepository.findById(CategoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        ProductEntity product = new ProductEntity();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product.setStock(request.getStock());
        product.setCategory(category);
        productRepository.save(product);
    }

    public List<ProductResponse> getProductByCategory(Long CategoryId) {
        List<ProductEntity> productEntities = productRepository.findByCategoryId(CategoryId);
        return productEntities.stream().map(productEntity -> {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(productEntity.getId());
            productResponse.setName(productEntity.getName());
            productResponse.setPrice(productEntity.getPrice());
            productResponse.setDescription(productEntity.getDescription());
            return productResponse;
        }).toList();
    }




}
