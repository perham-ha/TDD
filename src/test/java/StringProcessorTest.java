import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.StringProcessor;

@DisplayName("StringProcessor TDD Demo")
public class StringProcessorTest {
    private StringProcessor stringProcessor;

    @BeforeEach
    public void setUp() {
        this.stringProcessor = new StringProcessor();
    }

    @Nested
    @DisplayName("String Reversal Tests")
    class StringReversalTests {
        @Test
        @DisplayName("Should reverse a simple string")
        void shouldReverseSimpleString() {

            // Create String input for test
            String expected = "dlrowolleh";

            // Save result from method string reversal method used on input
            String result = stringProcessor.reverse("helloworld");

            // Check if returned value matches expected value
            assertEquals(expected, result);
        }
    }

}
