package programmer.task.klaczynski.domain;

import programmer.task.klaczynski.api.Rule;
import programmer.task.klaczynski.impl.Checkout;
import programmer.task.klaczynski.impl.DummyRuleAmountForPrice;
import programmer.task.klaczynski.impl.DummyRuleBuySomeGetSomeForFree;
import programmer.task.klaczynski.impl.DummyRuleDiscountOnUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RuleDiscountOnUnitTest {
    @org.junit.Test

    public void getSubTotalWithDiscount() throws Exception {

        Product apple = new Product(1, "Apple", new BigDecimal(0.53));
        Product orange = new Product(2, "Orange", new BigDecimal(0.99));
        Product kiwi = new Product(3, "Kiwi", new BigDecimal(0.39));
        Product avocado = new Product(4, "Avocado", new BigDecimal(0.89));

        Rule rule1 = new RuleAmountForPrice(3, new BigDecimal(1.33));
        Rule rule2 = new RuleBuySomeGetSomeForFree(3, 1);
        Rule rule3 = new RuleDiscountOnUnit(1, new BigDecimal(0.59));

        Map offers = new HashMap<Integer, Rule>();

        offers.put(apple.getSku(), rule1);
        offers.put(kiwi.getSku(), rule2);
        offers.put(avocado.getSku(), rule3);

        Checkout checkout = new Checkout();
        assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(apple, new BigDecimal(0), offers));
        assertEquals(new BigDecimal(0.53).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(apple, new BigDecimal(1), offers));
        assertEquals(new BigDecimal(1.06).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(apple, new BigDecimal(2), offers));
        assertEquals(new BigDecimal(1.33).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(apple, new BigDecimal(3), offers));
        assertEquals(new BigDecimal(1.86).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(apple, new BigDecimal(4), offers));
        assertEquals(new BigDecimal(2.39).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(apple, new BigDecimal(5), offers));
        assertEquals(new BigDecimal(2.66).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(apple, new BigDecimal(6), offers));
        assertEquals(new BigDecimal(3.19).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(apple, new BigDecimal(7), offers));

        assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(orange, new BigDecimal(0), offers));
        assertEquals(new BigDecimal(0.99).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(orange, new BigDecimal(1), offers));
        assertEquals(new BigDecimal(1.98).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(orange, new BigDecimal(2), offers));

        assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(kiwi, new BigDecimal(0), offers));
        assertEquals(new BigDecimal(0.39).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(kiwi, new BigDecimal(1), offers));
        assertEquals(new BigDecimal(0.78).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(kiwi, new BigDecimal(2), offers));
        assertEquals(new BigDecimal(1.17).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(kiwi, new BigDecimal(3), offers));
        assertEquals(new BigDecimal(1.17).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(kiwi, new BigDecimal(4), offers));
        assertEquals(new BigDecimal(1.56).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(kiwi, new BigDecimal(5), offers));
        assertEquals(new BigDecimal(1.95).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(kiwi, new BigDecimal(6), offers));
        assertEquals(new BigDecimal(2.34).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(kiwi, new BigDecimal(7), offers));

        assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(avocado, new BigDecimal(0), offers));
        assertEquals(new BigDecimal(0.59).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(avocado, new BigDecimal(1), offers));
        assertEquals(new BigDecimal(1.18).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(avocado, new BigDecimal(2), offers));
        assertEquals(new BigDecimal(1.77).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(avocado, new BigDecimal(3), offers));
        assertEquals(new BigDecimal(2.36).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(avocado, new BigDecimal(4), offers));
        assertEquals(new BigDecimal(2.95).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(avocado, new BigDecimal(5), offers));
        assertEquals(new BigDecimal(3.54).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(avocado, new BigDecimal(6), offers));
        assertEquals(new BigDecimal(4.13).setScale(2, RoundingMode.HALF_UP), checkout.calculateSubTotal(avocado, new BigDecimal(7), offers));



    }

}