import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() throws Exception {
        this.calculator = new Calculator();
    }

    @Test
    @DisplayName("twoPositiveNumberAdditionTest")
    public void testAdd() {
        int expected = 20;
        int result = calculator.add(5, 15);
        Assertions.assertEquals(expected, result);
    }
}
