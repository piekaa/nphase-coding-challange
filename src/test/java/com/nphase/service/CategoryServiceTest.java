package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class CategoryServiceTest {
    private final CategoryService categoryService = new CategoryService();

    @Test
    public void quantityPerCategory() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 2, "drinks"),
                new Product("Coffee", BigDecimal.valueOf(3.5), 2, "drinks"),
                new Product("Coffee", BigDecimal.valueOf(8), 2, "food")
        ));

        Map<String, Integer> quantityPerCategory = categoryService.quantityPerCategory(cart);

        Assertions.assertEquals(4, quantityPerCategory.get("drinks"));
        Assertions.assertEquals(2, quantityPerCategory.get("food"));
    }
}