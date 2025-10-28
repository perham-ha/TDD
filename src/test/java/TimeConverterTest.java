import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimeConverterTest {
    private TimeConverter converter;

    @BeforeEach
    public void setUp() {
        this.converter = new TimeConverter();
    }

    @Test
    @DisplayName("Should convert 60 seconds to 1 minute")
    void shouldConvert60SecondsTo1Minute() {
        assertThat(converter.secondsToMinutes(60)).isEqualTo(1.0);
    }
}
