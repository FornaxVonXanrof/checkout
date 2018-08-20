package programmer.task.klaczynski.api;

import programmer.task.klaczynski.domain.Product;

import java.math.BigDecimal;

public interface Rule {

    BigDecimal getSubTotalWithDiscount(Product product, BigDecimal quantity);
}
