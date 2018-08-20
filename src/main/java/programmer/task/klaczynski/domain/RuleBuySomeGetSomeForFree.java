package programmer.task.klaczynski.domain;

import programmer.task.klaczynski.api.Rule;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * defines an offer where
 * eg. buy 2 get one 1
 */

public class RuleBuySomeGetSomeForFree implements Rule {

    private int buy;
    private int freebiesAmount;

    public BigDecimal getSubTotalWithDiscount(Product product, BigDecimal quantity) {
        int set = buy + freebiesAmount;
        int quantityInt = quantity.intValue();

        if (checkScannedProducts(quantityInt, set, this.buy, this.freebiesAmount) == 0) {

            return product.getPrice().multiply(new BigDecimal(checkHowManyToPay(quantityInt, set, this.buy)))
                    .setScale(2, RoundingMode.HALF_UP);

        } else if (quantityInt % set >= 1) {
            return product.getPrice().multiply(new BigDecimal(checkHowManyToPay(quantityInt, set, this.buy) + quantityInt % set))
                    .setScale(2, RoundingMode.HALF_UP);
        } else {

            return product.getPrice().multiply(quantity);

        }
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getFreebiesAmount() {
        return freebiesAmount;
    }

    public void setFreebiesAmount(int freebiesAmount) {
        this.freebiesAmount = freebiesAmount;
    }

    public RuleBuySomeGetSomeForFree(int buy, int freebiesAmount) {
        this.buy = buy;
        this.freebiesAmount = freebiesAmount;
    }

    /**
     * check scanned amount of product if it is enough to trigger conditions
     * @param quantityInt
     * @param set
     * @param buy
     * @param freebiesAmount
     * @return
     */
    private int checkScannedProducts(int quantityInt, int set, int buy, int freebiesAmount) {
        return quantityInt - ((quantityInt / set * buy) + (quantityInt / set * freebiesAmount));
    }

    /**
     * check for how many items has been to pay
     * @param quantityInt
     * @param set
     * @param buy
     * @return
     */
    private int checkHowManyToPay(int quantityInt, int set, int buy) {

        return quantityInt / set * buy;

    }
}
