package programmer.task.klaczynski.impl;

import programmer.task.klaczynski.api.Rule;
import programmer.task.klaczynski.domain.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Checkout {

    public BigDecimal calculateSubTotal(Product product, BigDecimal quantity, Map<Product, Rule> offers) {

        if (!offers.containsKey(product.getSku())) {

            return product.getPrice().multiply(quantity).setScale(2, RoundingMode.HALF_UP);

        } else {

            return offers.get(product.getSku()).getSubTotalWithDiscount(product, quantity);

        }
    }

}
