package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyConverter {
    public BigDecimal usdToEur(BigDecimal ownedCurrency) {
        if (ownedCurrency.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The owned currency is negative");
        } else {
            BigDecimal amount = ownedCurrency.multiply(new BigDecimal("0.92"));

            amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
            return amount;
        }
    }

    public BigDecimal eurToUsd(BigDecimal ownedCurrency) {
        BigDecimal conversationRate = new BigDecimal("1.00").divide(new BigDecimal("0.92"), 10, RoundingMode.HALF_UP);
        BigDecimal amount = ownedCurrency.multiply(conversationRate);

        amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        return amount;
    }
}
