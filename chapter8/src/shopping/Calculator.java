package shopping;

import java.time.LocalDate;
import java.util.Set;

public class Calculator {

    public static long calculate(Set<Product> products, LocalDate dateOfPurchase) {
        return products.stream()
                .mapToLong(product -> product.getPrice(dateOfPurchase))
                .sum();
    }
}
