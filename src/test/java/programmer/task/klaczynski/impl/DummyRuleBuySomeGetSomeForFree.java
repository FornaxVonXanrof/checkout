package programmer.task.klaczynski.impl;

import programmer.task.klaczynski.domain.Product;
import programmer.task.klaczynski.domain.RuleBuySomeGetSomeForFree;

import java.math.BigDecimal;

public class DummyRuleBuySomeGetSomeForFree extends RuleBuySomeGetSomeForFree {

    public DummyRuleBuySomeGetSomeForFree(int buy, int freebiesAmount) {
        super(buy, freebiesAmount);
    }

    @Override
    public BigDecimal getSubTotalWithDiscount(Product product, BigDecimal quantity) {

        return new BigDecimal(2);
    }

}
