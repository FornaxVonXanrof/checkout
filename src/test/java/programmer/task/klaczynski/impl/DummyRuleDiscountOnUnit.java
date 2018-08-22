package programmer.task.klaczynski.impl;

import programmer.task.klaczynski.domain.Product;
import programmer.task.klaczynski.domain.RuleDiscountOnUnit;

import java.math.BigDecimal;

public class DummyRuleDiscountOnUnit extends RuleDiscountOnUnit {

    public DummyRuleDiscountOnUnit(int amount, BigDecimal specialPrice) {
        super(amount, specialPrice);
    }

    @Override
    public BigDecimal getSubTotalWithDiscount(Product product, BigDecimal quantity) {

        return new BigDecimal(3);
    }

}
