import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import utils.StringProcessor;

import static org.junit.jupiter.api.Assertions.*;

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

        @Test
        @DisplayName("Should handle a single character")
        void shouldHandleSingleCharacter() {
            assertEquals("x", stringProcessor.reverse("x"));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Should handle null and empty strings")
        void shouldHandleNullAndEmptyStrings(String input) {
            // Save result from reverse method
            String result = stringProcessor.reverse(input);

            // Assertions to see that values are as expected
            if (input == null) {
                assertNull(result, "Null should return null");
            } else {
                assertEquals("", result, "Empty string should return an empty string");
            }
        }

        @Test
        @DisplayName("Should preserve spaces in reversal")
        void shouldPreserveSpacesInReversal() {
            String input = "a b c";
            String expected = "c b a";

            String result = stringProcessor.reverse(input);

            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Palindrome Detection Tests")
    class PalindromeDetectionTests {
        @Test
        @DisplayName("Should detect simple palindrome")
        void shouldDetectSimplePalindrome() {
            // Given
            String input = "racecar";

            // When
            // Then
            assertTrue(stringProcessor.isPalindrome(input));

        }

        @Test
        @DisplayName("Should detect non-palindrome")
        void shouldDetectNonPalindrome() {
            // Given
            String input = "notpalindrome";

            // When
            // Then
            assertFalse(stringProcessor.isPalindrome(input));
        }

        @Test
        @DisplayName("Should handle case-insensitive palindromes")
        void shouldHandleCaseInsensitivePalindromes() {
            // Given
            String input = "RaCeCar";

            // When
            // Then
            assertTrue(stringProcessor.isPalindrome(input));
        }

        @Test
        @DisplayName("Should handle palindromes with spaces")
        void shouldHandlePalindromesWithSpaces() {
            // Given
            String input = "Draw o coward";

            // When
            // Then
            assertTrue(stringProcessor.isPalindrome(input));
        }

        @Test
        @DisplayName("Should handle single characters as palindrome")
        void shouldHandleSingleCharacterAsPalindrome() {
            // Given
            String input = "a";

            // When
            // Then
            assertTrue(stringProcessor.isPalindrome(input));
        }
    }
}
