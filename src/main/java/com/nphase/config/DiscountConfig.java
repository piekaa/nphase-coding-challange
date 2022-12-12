package com.nphase.config;

import java.math.BigDecimal;

public class DiscountConfig {
    /**
     * e.g. 0.1 for 10% discount
     */
    public final BigDecimal discountPercentage;
    public final int itemsPerCategoryRequiredForDiscount;

    public DiscountConfig(BigDecimal discountPercentage, int itemsPerCategoryRequiredForDiscount) {
        this.discountPercentage = discountPercentage;
        this.itemsPerCategoryRequiredForDiscount = itemsPerCategoryRequiredForDiscount;
    }
}
