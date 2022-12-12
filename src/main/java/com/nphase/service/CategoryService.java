package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;

import java.util.HashMap;
import java.util.Map;

class CategoryService {

    Map<String, Integer> quantityPerCategory(ShoppingCart shoppingCart) {
        Map<String, Integer> quantityPerCategory = new HashMap<>();
        for (Product product : shoppingCart.getProducts()) {
            quantityPerCategory.putIfAbsent(product.getCategory(), 0);
            quantityPerCategory.put(product.getCategory(),
                    quantityPerCategory.get(product.getCategory()) + product.getQuantity());
        }
        return quantityPerCategory;
    }
}
