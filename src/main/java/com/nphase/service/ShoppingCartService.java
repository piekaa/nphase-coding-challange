package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;

public class ShoppingCartService {
    private final PriceService priceService;
    private final CategoryService categoryService;

    public ShoppingCartService(PriceService priceService, CategoryService categoryService) {
        this.priceService = priceService;
        this.categoryService = categoryService;
    }

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        Map<String, Integer> quantityPerCategory = categoryService.quantityPerCategory(shoppingCart);

        return shoppingCart.getProducts()
                .stream()
                .map(product ->
                        priceService.price(product, quantityPerCategory.get(product.getCategory()))
                )
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
