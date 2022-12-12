package com.nphase.service;

import com.nphase.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PriceServiceTest {
    private final PriceService discountService = new PriceService();

    @Test
    public void calculatesPriceWithDiscount() {
        BigDecimal result = discountService.price(
                new Product("Tea", BigDecimal.valueOf(5.0), 5));

        Assertions.assertEquals(0, BigDecimal.valueOf(22.5).compareTo(result));
    }

    @Test
    public void calculatesPriceWithoutDiscount() {
        BigDecimal result = discountService.price(
                new Product("Coffee", BigDecimal.valueOf(3.5), 3));

        Assertions.assertEquals(0, BigDecimal.valueOf(10.5).compareTo(result));
    }
}