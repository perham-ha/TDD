import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    @DisplayName("twoPositiveNumberAdditionTest")
    public void testAdd() {
        int expected = 20;
        int result = calculator.add(5, 15);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("additionWithZero")
    public void testAddZero() {
        int expected = 10;
        int result = calculator.add(10, 0);
        Assertions.assertEquals(expected, result);
    }
}
