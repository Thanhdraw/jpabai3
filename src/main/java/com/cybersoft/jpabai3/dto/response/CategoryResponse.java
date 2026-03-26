package com.cybersoft.jpabai3.dto.response;


import com.cybersoft.jpabai3.entity.product.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CategoryResponse {

    private String name;

    private List<ProductResponse> products = new ArrayList<>();
}
