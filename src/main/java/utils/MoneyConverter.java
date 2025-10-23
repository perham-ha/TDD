package utils;

import java.math.BigDecimal;

public class MoneyConverter {
    public BigDecimal usdToEur(BigDecimal ownedCurrency) {
        return ownedCurrency.multiply(new BigDecimal("0.92"));
    }
}
