package com.cybersoft.jpabai3.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductResponse {

    private Long id;
    private String name;

    private BigDecimal price;

    private String description;

}
