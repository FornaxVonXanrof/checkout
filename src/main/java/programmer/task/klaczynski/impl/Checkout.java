package programmer.task.klaczynski.impl;

import programmer.task.klaczynski.api.Rule;
import programmer.task.klaczynski.domain.Product;

import java.math.BigDecimal;
import java.util.Map;

public class Checkout {
//    private Product product;
//    private BigDecimal quantity;
//    private Map<Integer, Rule> offers;
//
//    public Checkout(Product product, BigDecimal quantity, Map<Integer, Rule> offers) {
//        this.product = product;
//        this.quantity = quantity;
//        this.offers = offers;
//    }

    public BigDecimal calculateSubTotal(Product product, BigDecimal quantity, Map<Integer, Rule> offers) {

        if (!offers.containsKey(product.getSku())) {
            return product.getPrice().multiply(quantity);
        } else {

            return offers.get(product.getSku()).getSubTotalWithDiscount(product, quantity);

        }
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public BigDecimal getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(BigDecimal quantity) {
//        this.quantity = quantity;
//    }
//
//    public Map<Integer, Rule> getOffers() {
//        return offers;
//    }
//
//    public void setOffers(Map<Integer, Rule> offers) {
//        this.offers = offers;
//    }
}
