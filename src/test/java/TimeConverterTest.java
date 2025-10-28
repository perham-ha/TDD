import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TimeConverter;

public class TimeConverterTest {
    private TimeConverter converter;

    @BeforeEach
    public void setUp() {
        this.converter = new TimeConverter();
    }

    @Test
    @DisplayName("Should convert 60 seconds to 1 minute")
    void shouldConvert60SecondsTo1Minute() {
        Assertions.assertThat(converter.secondsToMinutes(60)).isEqualTo(1.0);
    }

    @Test
    @DisplayName("Should throw exception for negative seconds")
    void shouldThrowExceptionForNegativeSeconds() {
        Assertions.assertThatThrownBy(() -> converter.secondsToMinutes(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("negative");
    }
}
