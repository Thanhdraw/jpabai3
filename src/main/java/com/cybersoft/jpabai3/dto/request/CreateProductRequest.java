package com.cybersoft.jpabai3.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank(message = "Tên không được để trống")
    private String name;
    private String description;

    @NotNull(message = "Giá không được null")
    @Positive(message = "Giá phải lớn hơn 0")
    private BigDecimal price;

    @Positive(message = "Số lượng phải lớn hơn 0")
    private int stock;

    private Long categoryId;

}
