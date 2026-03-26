package com.cybersoft.jpabai3.controller;

import com.cybersoft.jpabai3.dto.request.CreateCategoryRequest;
import com.cybersoft.jpabai3.dto.request.ProductInCategoryRequest;
import com.cybersoft.jpabai3.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService  categoryService;


    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryRequest request) {
        categoryService.createCategory(request);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }


    @PostMapping("/{id}/products")
    public ResponseEntity<?> addProduct(
            @PathVariable Long id,
            @RequestBody ProductInCategoryRequest request
    ) {
        categoryService.createProduct(id, request);
        return ResponseEntity.ok("Product added");
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<?> getProducts(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getProductByCategory(id));
    }
}
