package com.cybersoft.jpabai3.repository;

import com.cybersoft.jpabai3.entity.product.CategoryEntity;
import com.cybersoft.jpabai3.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByCategoryId(Long categoryId);
}
