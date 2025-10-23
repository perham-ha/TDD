import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.MoneyConverter;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyConverterTest {
    private MoneyConverter converter;

    @BeforeEach
    public void setUp() {
        this.converter = new MoneyConverter();
    }

    @Test
    @DisplayName("Should convert 100 USD to 92 EUR")
    void shouldConvert100UsdToEur() {
        BigDecimal usd = new BigDecimal("100.00");
        BigDecimal result = converter.usdToEur(usd);
        assertThat(result).isEqualByComparingTo("92.00");
    }

    @Test
    @DisplayName("Should convert 200 USD to 184 EUR")
    void shouldConvert200UsdToEur() {
        BigDecimal usd = new BigDecimal("200.00");
        BigDecimal result = converter.usdToEur(usd);
        assertThat(result).isEqualByComparingTo("184.00");
    }

    @Test
    @DisplayName("Should have two decimals during conversion")
    void shouldHaveTwoDecimalsDuringConversion() {
        BigDecimal usd = new BigDecimal("239.2");
        BigDecimal result = converter.usdToEur(usd);
        assertThat(result).isEqualByComparingTo("220.06");
    }
}
