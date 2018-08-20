package programmer.task.klaczynski.domain;

import programmer.task.klaczynski.api.Rule;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * defines a rule for a offer
 * eg. get 3 for 1.30
 */

public class RuleAmountForPrice implements Rule {

    private int amount;
    private BigDecimal specialPrice;

    /**
     * @param product
     * @param quantity of the product that has been scanned
     * @return
     */
    public BigDecimal getSubTotalWithDiscount(Product product, BigDecimal quantity) {

        int tempQuantity = quantity.intValue() / this.amount;
        int rest = quantity.intValue() % this.amount;
        /**
         * multiply the given amount with the special price
         * if there some products not obtained to the offer calculate the normal price
         */
        BigDecimal result = this.specialPrice.multiply(new BigDecimal(tempQuantity)).add(product.getPrice().multiply(new BigDecimal(rest)));

        /**
         * format the result by digits after coma and round it up
         */
        return result.setScale(2, RoundingMode.HALF_UP);
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

    public RuleAmountForPrice(int amount, BigDecimal specialPrice) {
        this.amount = amount;
        this.specialPrice = specialPrice;
    }
}
