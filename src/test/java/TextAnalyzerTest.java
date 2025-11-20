import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Complex TextAnalyzer TDD Demo")
public class TextAnalyzerTest {
    private TextAnalyzer analyzer;
    private Calculator calculator;
    private StringProcessor stringProcessor;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        stringProcessor = new StringProcessor();
        analyzer = new TextAnalyzer(calculator, stringProcessor);
    }

    @Nested
    @DisplayName("Sentiment Analysis Test")
    class SentimentAnalysisTest {

        @Test
        @DisplayName("Should analyze positive sentiment correctly")
        void shouldAnalyzePositiveSentimentCorrectly() {
            // Given
            String positiveText = "This is such a lovely and beautiful day";

            // When
            SentimentResult result = analyzer.analyzeSentiment(positiveText);

            // Then
            assertThat(result.getPositiveWordCount()).isGreaterThan(0);                 // Expects more than 0 positive words
            assertThat(result.getSentimentCategory()).isEqualTo(SentimentCategory.POSITIVE);  // Expects a positive ENUM
            assertThat(result.getSentimentScore()).isGreaterThan(0.5);                    // Expects a sentiment score above 0
        }

        @Test
        @DisplayName("Should analyze negative sentiment correctly")
        void shouldAnalyzeNegativeSentimentCorrectly() {
            // Given
            String positiveText = "I think we are all doomed, this is useless.";

            // When
            SentimentResult result = analyzer.analyzeSentiment(positiveText);

            // Then
            assertThat(result.getNegativeWordCount()).isGreaterThan(0);                 // Expects more than 0 positive words
            assertThat(result.getSentimentCategory()).isEqualTo(SentimentCategory.NEGATIVE);  // Expects a positive ENUM
            assertThat(result.getSentimentScore()).isLessThan(-0.5);                  // Expects a sentiment score above 0
        }
    }
}