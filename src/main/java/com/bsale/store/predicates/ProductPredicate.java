package com.bsale.store.predicates;

import com.bsale.store.dto.ProductDTO;

import java.util.function.Predicate;

public class ProductPredicate {
    public static Predicate<ProductDTO> isOfCategory(long categoryId) {
        return p -> p.getCategory().getId() == categoryId;
    }

    public static Predicate<ProductDTO> containsName(String name) {
        return p -> p.getName().toLowerCase().contains(name);
    }
}
