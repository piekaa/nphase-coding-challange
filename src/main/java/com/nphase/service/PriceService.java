package com.nphase.service;

import com.nphase.config.DiscountConfig;
import com.nphase.entity.Product;

import java.math.BigDecimal;

class PriceService {
    private final DiscountConfig discountConfig;

    PriceService(DiscountConfig discountConfig) {
        this.discountConfig = discountConfig;
    }

    BigDecimal price(Product product, int quantityInCategory) {
        return quantityInCategory > discountConfig.itemsPerCategoryRequiredForDiscount ? priceWithDiscount(product)
                : priceWithoutDiscount(product);
    }

    private BigDecimal priceWithDiscount(Product product) {
        return priceWithoutDiscount(product).multiply(BigDecimal.valueOf(1).subtract(discountConfig.discountPercentage));
    }

    private BigDecimal priceWithoutDiscount(Product product) {
        return product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity()));
    }
}
