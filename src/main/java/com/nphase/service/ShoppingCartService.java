package com.nphase.service;

import com.nphase.entity.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingCartService {
    private final PriceService priceService;

    public ShoppingCartService(PriceService priceService) {
        this.priceService = priceService;
    }

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts()
                .stream()
                .map(priceService::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
