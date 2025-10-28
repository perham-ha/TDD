package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyConverter {

    // Logic that handles usdToEur conversions.
    public BigDecimal usdToEur(BigDecimal ownedCurrency) {
        if (ownedCurrency.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The owned currency is negative");   // Throw IllegalArgument at negative numbers
        } else {
            BigDecimal amount = ownedCurrency.multiply(new BigDecimal("0.92"));

            amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);  // Rounds to two decimals
            return amount;
        }
    }

    // Logic that handles eurToUsd conversions.
    public BigDecimal eurToUsd(BigDecimal ownedCurrency) {
        // BigDecimal.divide throws Arithmetic Exception unless Rounding is set
        // ref. https://stackoverflow.com/questions/12178053/dividing-bigdecimals-results-in-arithmeticexception
        BigDecimal conversationRate = new BigDecimal("1.00").divide(new BigDecimal("0.92"), 10, RoundingMode.HALF_UP);
        BigDecimal amount = ownedCurrency.multiply(conversationRate);

        amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        return amount;
    }
}
