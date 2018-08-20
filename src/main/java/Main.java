import programmer.task.klaczynski.api.Rule;
import programmer.task.klaczynski.domain.Product;
import programmer.task.klaczynski.domain.RuleAmountForPrice;
import programmer.task.klaczynski.domain.RuleBuySomeGetSomeForFree;
import programmer.task.klaczynski.domain.RuleDiscountOnUnit;
import programmer.task.klaczynski.impl.Checkout;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){

       Rule rule1 = new RuleAmountForPrice(3, new BigDecimal(1.33));
       Rule rule2 = new RuleBuySomeGetSomeForFree(2,1);
       Rule rule3 = new RuleDiscountOnUnit(1, new BigDecimal(1.99));

       Product apple = new Product(1, "Apple", new BigDecimal(0.53));
       Product orange = new Product(2, "Orange", new BigDecimal(0.99));

        Map offers = new HashMap<Integer, Rule>();
        offers.put(apple.getSku(), rule1);
        offers.put(orange.getSku(), rule2);
        offers.put(orange.getSku(), rule3);

//        Checkout checkout = new Checkout(apple, new BigDecimal(3), offers);
        Checkout checkout = new Checkout();
//        System.out.println(checkout.calculateSubTotal(apple, new BigDecimal(3), offers));
//        System.out.println(checkout.calculateSubTotal(apple, new BigDecimal(5), offers));
//        System.out.println(checkout.calculateSubTotal(apple, new BigDecimal(10), offers));
//
//        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(3), offers));
//        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(6), offers));
//        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(9), offers));
//        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(12), offers));

//        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(2), offers));
//        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(5), offers));
//        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(7), offers));
//        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(9), offers));
//        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(11), offers));

        System.out.println(checkout.calculateSubTotal(orange, new BigDecimal(11), offers));



    }

}
