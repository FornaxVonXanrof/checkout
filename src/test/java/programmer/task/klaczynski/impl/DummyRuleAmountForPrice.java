package programmer.task.klaczynski.impl;

import programmer.task.klaczynski.domain.Product;
import programmer.task.klaczynski.domain.RuleAmountForPrice;

import java.math.BigDecimal;

public class DummyRuleAmountForPrice extends RuleAmountForPrice {

    public DummyRuleAmountForPrice(int amount, BigDecimal specialPrice) {
        super(amount, specialPrice);
    }

    @Override
    public BigDecimal getSubTotalWithDiscount(Product product, BigDecimal quantity) {

        return new BigDecimal(1);
    }

}

