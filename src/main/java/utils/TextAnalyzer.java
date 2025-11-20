package utils;

import java.util.Set;

public class TextAnalyzer {
    private final Calculator calculator;
    private final StringProcessor stringProcessor;

    private static final Set<String> POSITIVE_WORDS = Set.of(
            "beautiful", "lovely", "happy", "glad", "awesome", "great", "love", "best"
    );

    private static final Set<String> NEGATIVE_WORDS = Set.of(
            "ugly", "despise", "sad", "depression", "hate", "bad", "worst", "hatred"
    );

    public TextAnalyzer(Calculator calculator, StringProcessor stringProcessor) {
        this.calculator = calculator;
        this.stringProcessor = stringProcessor;
    }

    public SentimentResult analyzeSentiment(String text) {

        // Convert text to predictable format
        String formattedText = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] listOfWords = formattedText.split("\\s+");

        int positiveWordCount = 0;
        int negativeWordCount = 0;

        // Count words of each type
        for (String word : listOfWords) {
            if (POSITIVE_WORDS.contains(word)) {
                positiveWordCount++;
            } else if (NEGATIVE_WORDS.contains(word)) {
                negativeWordCount++;
            }
        }

        // Calculate sentiment score with `Calculator`
        int totalWordCount = listOfWords.length;
        double positiveRatio = totalWordCount > 0 ? calculator.divide(positiveWordCount, totalWordCount) : 0;
        double negativeRatio = totalWordCount > 0 ? calculator.divide(negativeWordCount, totalWordCount) : 0;

        // Sentiment scoring logic
        double sentimentScore = (positiveRatio - negativeRatio) * 5.0;

        // Categorization depending on sentimentScore and sentimentCount
        SentimentCategory category;
        if (sentimentScore > 0.5 || positiveWordCount > 0) {
            category = SentimentCategory.POSITIVE;
        } else if (sentimentScore < -0.5 || negativeWordCount > 0) {
            category = SentimentCategory.NEGATIVE;
        } else {
            category = SentimentCategory.NEUTRAL;
        }

        return new SentimentResult(sentimentScore, category, positiveWordCount, negativeWordCount);
    }
}
