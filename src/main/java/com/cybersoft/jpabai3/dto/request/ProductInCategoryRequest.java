package com.cybersoft.jpabai3.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductInCategoryRequest {

    private String name;
    private BigDecimal price;
    private String description;
    private int stock;
}
