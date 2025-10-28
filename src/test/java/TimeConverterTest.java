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
        Assertions.assertThatThrownBy(() -> converter.secondsToMinutes(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }

    @Test
    @DisplayName("Should convert 60 minutes to 1 hour")
    void shouldConvert60MinutesTo1Hour() {
        Assertions.assertThat(converter.minutesToHours(60)).isEqualTo(1.0);
    }

    @Test
    @DisplayName("Should convert 1 minute to 60 seconds")
    void shouldConvert1MinuteTo60Seconds() {
        Assertions.assertThat(converter.minutesToSeconds(1)).isEqualTo(60);
    }

    @Test
    @DisplayName("Should throw exception for negative minutes")
    void shouldThrowExceptionForNegativeMinutes() {
        // Tests negative minutes in `minutesToSeconds`
        Assertions.assertThatThrownBy(() -> converter.minutesToSeconds(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");

        // Tests negative minutes in `minutesToHours`
        Assertions.assertThatThrownBy(() -> converter.minutesToHours(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }
}
