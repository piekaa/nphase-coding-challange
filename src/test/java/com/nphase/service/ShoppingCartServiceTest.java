package com.nphase.service;


import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingCartServiceTest {
    private final ShoppingCartService service = new ShoppingCartService(new PriceService());

    @Test
    public void calculatesPrice()  {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.0), 5),
                new Product("Coffee", BigDecimal.valueOf(3.5), 3)
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(0, BigDecimal.valueOf(33).compareTo(result));
    }
}