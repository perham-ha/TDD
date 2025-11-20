import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.Calculator;

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
    public void shouldAddTwoNumbers(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "0, 10, -10"
    })
    public void shouldSubtractTwoNumbers(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 3, 12",
            "3, 0, 0"
    })
    public void shouldMultiplyTwoNumber(int a, int b, int expected) {
        Assertions.assertEquals(expected, calculator.multiply(a, b));
    }

    @Test
    @DisplayName("Should divide two numbers")
    public void shouldDivideTwoNumbers() {
        double expected = 7;
        Assertions.assertEquals(expected, calculator.divide(21, 3));
    }

    @Test
    @DisplayName("Should hande decimal division")
    public void shouldHandleDecimalDivision() {
        double expected = 5;
        Assertions.assertEquals(expected, calculator.divideDecimals(12.5, 2.5));
    }
}
