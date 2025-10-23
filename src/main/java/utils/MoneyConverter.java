package utils;

import java.math.BigDecimal;

public class MoneyConverter {
    public BigDecimal usdToEur(BigDecimal ownedCurrency) {
        BigDecimal amount = ownedCurrency.multiply(new BigDecimal("0.92"));

        amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        return amount;
    }
}
