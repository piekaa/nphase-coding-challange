package com.nphase.service;


import com.nphase.config.DiscountConfig;
import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingCartServiceTest {
    private final ShoppingCartService service = new ShoppingCartService(
            new PriceService(new DiscountConfig(BigDecimal.valueOf(0.1), 3)),
            new CategoryService());

    @Test
    public void calculatesPrice()  {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 2, "drinks"),
                new Product("Coffee", BigDecimal.valueOf(3.5), 2, "drinks"),
                new Product("Coffee", BigDecimal.valueOf(8), 2, "food")
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(0, BigDecimal.valueOf(31.84).compareTo(result));
    }
}