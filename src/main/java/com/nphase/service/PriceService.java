package com.nphase.service;

import com.nphase.entity.Product;

import java.math.BigDecimal;

class PriceService {

    BigDecimal price(Product product) {
        return product.getQuantity() > 3 ? priceWithDiscount(product)
                : priceWithoutDiscount(product);
    }

    private BigDecimal priceWithDiscount(Product product) {
        return priceWithoutDiscount(product).multiply(BigDecimal.valueOf(0.9));
    }

    private BigDecimal priceWithoutDiscount(Product product) {
        return product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity()));
    }
}
