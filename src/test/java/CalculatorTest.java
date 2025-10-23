import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
            "2,7,9",
            "0, 3, 3",
            "5, 0, 5",
            "-5, -10, -15"
    })
    public void add_IntegerAddition(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.add(a, b));
    }

    @Test
    @DisplayName("Should subtract two numbers")
    public void subtract_IntegerSubtraction() {
        int expected = 2;
        Assertions.assertEquals(expected, calculator.subtract(5, 3));
    }
}
