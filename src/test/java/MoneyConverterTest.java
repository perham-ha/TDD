import org.junit.jupiter.api.*;
import utils.MoneyConverter;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyConverterTest {
    private MoneyConverter converter;

    @BeforeEach
    public void setUp() {
        this.converter = new MoneyConverter();
    }

    @Nested
    @DisplayName("USD to EUR Conversion")
    class usdToEurTest {

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

        @Test
        @DisplayName("Should throw exception for negative USD")
        void shouldThrowExceptionForNegativeUsd() {
            BigDecimal usd = new BigDecimal("-1");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                converter.usdToEur(usd);
            });
        }
    }

    @Nested
    @DisplayName("EUR to USD Conversion")
    class eurToUsdTest {

        @Test
        @DisplayName("Should convert 92 EUR to 100 USD")
        void shouldConvert92EurToUsd() {
            BigDecimal usd = new BigDecimal("92.00");
            BigDecimal result = converter.eurToUsd(usd);
            assertThat(result).isEqualByComparingTo("100.00");
        }

        @Test
        @DisplayName("Should convert 184 EUR to 200 USD")
        void shouldConvert184EurToUsd() {
            BigDecimal usd = new BigDecimal("184.00");
            BigDecimal result = converter.eurToUsd(usd);
            assertThat(result).isEqualByComparingTo("200.00");
        }
    }
}
