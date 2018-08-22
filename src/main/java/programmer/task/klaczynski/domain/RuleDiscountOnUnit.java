package programmer.task.klaczynski.domain;

import programmer.task.klaczynski.api.Rule;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * defines an discount on a product per unit
 */
public class RuleDiscountOnUnit implements Rule {

    private int amount;
    private BigDecimal specialPrice;

    public BigDecimal getSubTotalWithDiscount(Product product, BigDecimal quantity) {
        return this.specialPrice.multiply(quantity).setScale(2, RoundingMode.HALF_UP);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(BigDecimal specialPrice) {
        this.specialPrice = specialPrice;
    }

    public RuleDiscountOnUnit(int amount, BigDecimal specialPrice) {
        this.amount = amount;
        this.specialPrice = specialPrice;
    }

}
