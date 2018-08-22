package programmer.task.klaczynski.impl;

import org.junit.Test;
import programmer.task.klaczynski.api.Rule;
import programmer.task.klaczynski.domain.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CheckoutTest {


    @Test
    public void calculateSubTotal() throws Exception {

        Product apple = new Product(1, "Apple", new BigDecimal(0.53));
        Product orange = new Product(2, "Orange", new BigDecimal(0.99));
        Product kiwi = new Product(3, "Kiwi", new BigDecimal(0.39));
        Product avocado = new Product(4, "Avocado", new BigDecimal(0.89));

        Rule rule1 = new DummyRuleAmountForPrice(3, new BigDecimal(1.33));
        Rule rule2 = new DummyRuleBuySomeGetSomeForFree(3, 1);
        Rule rule3 = new DummyRuleDiscountOnUnit(3, new BigDecimal(1.33));

        Map offers = new HashMap<Integer, Rule>();

        offers.put(apple.getSku(), rule1);
        offers.put(kiwi.getSku(), rule2);
        offers.put(avocado.getSku(), rule3);

        Checkout checkout = new Checkout();
        assertEquals(new BigDecimal(1), checkout.calculateSubTotal(apple, new BigDecimal(1), offers));
        assertEquals(new BigDecimal(0.99).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(orange, new BigDecimal(1), offers));

        assertEquals(new BigDecimal(2), checkout.calculateSubTotal(kiwi, new BigDecimal(1), offers));
        assertEquals(new BigDecimal(3), checkout.calculateSubTotal(avocado, new BigDecimal(1), offers));


    }

}