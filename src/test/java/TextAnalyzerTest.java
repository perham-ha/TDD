import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.SentimentCategory;
import utils.SentimentResult;
import utils.StringProcessor;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
            SentimentResult result = analyser.analyzeSentiment(positiveText);

            // Then
            assertThat(result.getPositiveWordCount()).isGreaterThan(0);
            assertThat(result.getSentimentCategory()).isEqualTo(SentimentCategory.POSITIVE);
            assertThat(result.getSentimentScore()).isGreaterThan(0);
        }
    }
}