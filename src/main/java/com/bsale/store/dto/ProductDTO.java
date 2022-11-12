package com.bsale.store.dto;

import com.bsale.store.entity.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO{
    private long id;
    private String name;
    private String urlImage;
    private double price;
    private int discount;
    private Category category;
}
