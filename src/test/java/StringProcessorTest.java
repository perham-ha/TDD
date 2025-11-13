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

    @Nested
    @DisplayName("String Manipulation Tests")
    class StringManipulationTests {
        @Test
        @DisplayName("Should capitalize first letter of each word")
        void shouldCapitalizeFirstLetterOfEachWord() {
            // Given
            String input = "hello world";
            String expected = "Hello World";

            // When
            String result = stringProcessor.capitalizeWords(input);

            // Then
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should handle single word capitalization")
        void shouldHandleSingleWordCapitalization() {
            // Given
            String input = "hello";
            String expected = "Hello";

            // When
            String result = stringProcessor.capitalizeWords(input);

            // Then
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should handle mixed case input in capitalization")
        void shouldHandleMixedCaseInputInCapitalization() {
            // Assumption to not normalize rest of string but manage to capitalize first regardless
            // Given
            String input = "hELlo WOrld";
            String expected = "HELlo WOrld";

            // When
            String result = stringProcessor.capitalizeWords(input);

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
        @DisplayName("Should handle null and empty strings in capitalization")
        void shouldHandleNullAndEmptyStringsInCapitalization(String input) {
            // Given
            // When
            String result = stringProcessor.capitalizeWords(input);

            // Then
            assertEquals(input, result);
        }

        @Test
        @DisplayName("Should check if string contains substring")
        void shouldCheckIfStringContainsSubstring() {
            // Given
            String input = "hello world";
            String substring = "world";

            // When
            boolean result = stringProcessor.containsSubstring(input, substring);

            // Then
            assertTrue(result);
        }

        @Test
        @DisplayName("Should check case-insensitive substring")
        void shouldCheckCaseInsensitiveSubstring() {
            // Given
            String input = "Hello World";
            String substring = "world";

            // When
            boolean result = stringProcessor.containsSubstring(input, substring);

            // Then
            assertTrue(result);
        }

        @Test
        @DisplayName("Should return false for non-existent substring")
        void shouldReturnFalseForNonExistentSubstring() {
            // Given
            String input = "hello world";
            String substring = "java";

            // When
            boolean result = stringProcessor.containsSubstring(input, substring);

            // Then
            assertFalse(result);
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Should return false for null and empty string or substring")
        void shouldReturnFalseForNullAndEmptyOrSubstring(String input) {
            // Given
            String  validString = "hello";

            // When
            // Then
            // Case 1 - Invalid string, valid substring
            assertFalse(stringProcessor.containsSubstring(input, validString));

            // Case 2 - Valid string, invalid substring
            assertFalse(stringProcessor.containsSubstring(validString, input));
        }

        @Test
        @DisplayName("Should remove duplicate characters")
        void shouldRemoveDuplicates() {
            // Given
            String input = "programming";
            String expected = "progamin";

            // When
            String result = stringProcessor.removeDuplicates(input);

            // Then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("Should handle string with no duplicates")
        void shouldHandleStringWithNoDuplicates() {
            // Given
            String input = "abcdefghijklmn";
            String expected = "abcdefghijklmn";

            // When
            String result = stringProcessor.removeDuplicates(input);

            // Then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("Should preserve order when removing duplicates")
        void shouldPreserveOrderWhenRemovingDuplicates() {
            // Given
            String input = "banana";
            String expected = "ban";

            // When
            String result = stringProcessor.removeDuplicates(input);

            // Then
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Should handle null and empty strings in duplicate removal")
        void shouldHandleNullAndEmptyStringsInDuplicateRemoval(String input) {
            // Given
            // Input values are null and empty

            // When
            String result = stringProcessor.removeDuplicates(input);

            // Then
            assertThat(result).isEqualTo(input);
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "+11234567890",
                "1234567890"
        })
        @DisplayName("Should validate US phone number format")
        void shouldValidateUSPhoneNumberFormat(String input) {
            // Given
            // ValueSource above

            // When
            boolean result = stringProcessor.isValidPhoneNumber(input);

            // Then
            assertThat(result).isTrue();
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "++11234567890",    // Double plus
                "abcdefghijk",      // Letters
                "1234-56-7890",     // Incorrect group
                "+1-23-4567890",    // Incorrect structure
                "+30-234567890",    // Incorrect country code
        })
        @DisplayName("Should reject invalid phone number formats")
        void shouldRejectInvalidPhoneNumberFormats(String input) {
            // Given
            // ValueSource above

            // When
            boolean result = stringProcessor.isValidPhoneNumber(input);

            // Then
            assertThat(result).isFalse();
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Should reject null and empty phone numbers")
        void shouldRejectNullAndEmptyPhoneNumbers(String input) {
            // Given in NullAndEmptySource

            // When
            // Then
            assertThat(stringProcessor.isValidPhoneNumber(input)).isFalse();
        }

        @ParameterizedTest
        @DisplayName("Should validate URL format")
        @ValueSource(strings = {
                "http://test.com",
                "https://test.com",
                "http://www.test.com",
                "https://www.test.com",
                "https://test.com:8080",
                "https://test.com?query=page",
                "http://test.com:8080",
                "http://test.com?query=page"
        })
        void shouldValidateURLFormat(String input) {
            // Given in ValueSource

            // When
            boolean result = stringProcessor.isValidURL(input);

            // Then
            assertThat(result).isTrue();
        }

        @ParameterizedTest
        @DisplayName("Should reject invalid URL formats")
        @ValueSource(strings = {
            "test.com",                 // No protocol
            "www.test.com",             // No protocol
            "hppt://test.com",          // Incorrect protocol
            "https:/test.com",          // Incorrect format
            "http//test.com",           // No colon
            "https://",                 // Only protocol
            "https://",                  // Only protocol
            "https://???",               // Invalid hostname
            "https:// spaceintest.com"  // Space in url
        })
        void shouldRejectInvalidURLFormats(String input) {
            // Given in ValueSource
            // When
            boolean result = stringProcessor.isValidURL(input);

            // Then
            assertThat(result).isFalse();
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Should reject null and empty validation inputs")
        void shouldRejectNullAndEmptyValidationInputs(String input) {
            assertThat(stringProcessor.isValidURL(input)).isFalse();
        }

        @Test
        @DisplayName("Should handle very long strings in reversal")
        void shouldHandleVeryLongStringsInReversal() {
            // Given
            int length = 500_000;
            StringBuilder testString = new StringBuilder(length);

            // Generates a long predictable string (all letter as `a`)
            for (int i = 0; i < length; i++) {
                testString.append('a');
            }
            String longString = testString.toString();

            // When
            String result = stringProcessor.reverse(longString);

            // Then
            assertEquals(length, result.length());
            assertEquals('a', result.charAt(0));            // `a` at start
            assertEquals('a', result.charAt(length - 1));   // Still `a` at end
        }

        @Test
        @DisplayName("Should handle strings with special characters")
        void shouldHandleStringsWithSpecialCharacters() {
            // Given
            String input = "åäö!#$;/@";
            String expected = "@/;$#!öäå";

            // When
            String result = stringProcessor.reverse(input);

            // Then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("Should handle Unicode characters")
        void shouldHandleUnicodeCharacters() {
            // Given - Farsi + Emoji
            String input = "تستش کن😊";
            String expected = "😊نک شتست";

            // When
            String result = stringProcessor.reverse(input);

            // Then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("Should handle very long palindrome check")
        void shouldHandleVeryLongPalindromeCheck() {
            // Given - long palindrome with repeated chars
            String palindrome = "abcba";
            String input = palindrome.repeat(100_000); // 500k chars

            // When
            boolean result = stringProcessor.isPalindrome(input);

            // Then
            assertThat(result).isTrue();
        }
    }
}