import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.StringProcessor;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Should handle null and empty as palindromes")
        void shouldHandleNullAndEmptyAsPalindromes(String input) {
            // Given (Will be null and Empty)
            boolean result = stringProcessor.isPalindrome(input);

            // When
            // Then
            assertTrue(result);
        }
    }
    @Nested
    @DisplayName("String Compression Tests")
    class StringCompressionTests {
        @Test
        @DisplayName("Should compress repeated characters")
        void shouldCompressRepeatedCharacters() {
            // Given
            String input = "aabbbcc";
            String expected = "a2b3c2";

            // When
            String result = stringProcessor.compress(input);

            // Then
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should return original if compression doesn't reduce length")
        void shouldReturnOriginalIfCompressionDoesNotReduceLength() {
            // Given
            String input = "abcde";
            String expected = "abcde";

            // When
            String result = stringProcessor.compress(input);

            // Then
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should handle single character")
        void shouldHandleSingleCharacter() {
            // Given
            String input = "a";
            String expected = "a";

            // When
            String result = stringProcessor.compress(input);

            // Then
            assertEquals(expected, result);
        }
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Should handle null and empty strings in compression")
        void shouldHandleNullAndEmptyStringsInCompression (String input) {
            // Given (Will be null and Empty)
            String result = stringProcessor.compress(input);

            // When
            // Then
            assertThat(result).isEqualTo(input == null ? "" : input);
        }
    }

    @Nested
    @DisplayName("Word Count Tests")
    class WordCountTests {
        @Test
        @DisplayName("Should count words in simple sentence")
        void shouldCountWordsInSimpleSentence() {
            // Given
            String input = "hello world";
            int expected = 2;

            // When
            int result = stringProcessor.countWords(input);

            // Then
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should handle multiple spaces between words")
        void shouldHandleMultipleSpacesBetweenWords() {
            // Given
            String input = "hello   world  again";
            int expected = 3;

            // When
            int result = stringProcessor.countWords(input);

            // Then
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should handle leading and trailing spaces")
        void shouldHandleLeadingAndTrailingSpaces() {
            // Given
            String input = " Hello world once again ";
            int expected = 4;

            // When
            int result = stringProcessor.countWords(input);

            // Then
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should count single word")
        void shouldCountSingleWord() {
            // Given
            String input = "hello";
            int expected = 1;

            // When
            int result = stringProcessor.countWords(input);

            // Then
            assertEquals(expected, result);
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {
                "   ",      // Spaces
                "\t",       // Tab
                "\n",       // Newline
                " \n \t "   // Mix of different whitespace
        })
        @DisplayName("Should return zero for null, empty, or whitespace-only strings")
        void shouldReturnZeroForNullAndEmptyOrWhitespaceOnlyStrings(String input) {
            // When
            int result = stringProcessor.countWords(input);

            // Then
            assertEquals(0, result);
        }
    }

    @Nested
    @DisplayName("Input Validation Tests")
    class InputValidationTests {
        @Test
        @DisplayName("Should validate email format")
        void shouldValidateEmailFormat() {
            // Given
            String input = "blackbeard@email.com";

            // When
            boolean result = stringProcessor.isValidEmail(input);

            // Then
            assertTrue(result);
        }

        @Test
        @DisplayName("Should reject invalid email formats")
        void shouldRejectInvalidEmailFormats() {
            // Given
            // When
            // Then
            assertThat(stringProcessor.isValidEmail("@email.com")).isFalse();
            assertThat(stringProcessor.isValidEmail("fun-test")).isFalse();
            assertThat(stringProcessor.isValidEmail("test@.")).isFalse();
            assertThat(stringProcessor.isValidEmail("test@test.")).isFalse();
            assertThat(stringProcessor.isValidEmail("test.test.test.com")).isFalse();
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {
                "   ",      // Spaces
                "\t",       // Tab
                "\n",       // Newline
                " \n \t "   // Mix of different whitespace
        })
        @DisplayName("Should reject null and empty emails")
        void shouldRejectNullAndEmptyEmails(String email) {
            // Given
            // When
            boolean result = stringProcessor.isValidEmail(email);

            // Then
            assertFalse(result);
        }
    }
}