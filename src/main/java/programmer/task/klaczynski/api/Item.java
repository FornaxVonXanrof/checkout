package programmer.task.klaczynski.api;

import programmer.task.klaczynski.domain.Product;

import java.math.BigDecimal;

public interface Item {

    Product createItem(int sku, String name, BigDecimal price);

}
