import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyConverterTest {
    @Test
    @DisplayName("Should convert 100 USD to 92 EUR")
    void shouldConvert100UsdToEur() {
        BigDecimal usd = new BigDecimal("100.00");
        BigDecimal result = converter.usdToEuro(usd);
        assertThat(result).isEqualByComparingTo("92.00");
    }
}
