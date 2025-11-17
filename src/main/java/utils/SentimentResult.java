package utils;

public class SentimentResult {
    private final double sentimentScore;                  // Numerical points
    private final SentimentCategory sentimentCategory;    // Categorizing
    private final int positiveWordCount;                  // Amount of positive words
    private final int negativeWordCount;                  // Amount of negative words

    public SentimentResult(double sentimentScore, SentimentCategory sentimentCategory,
                           int positiveWordCount, int negativeWordCount) {
        this.sentimentScore = sentimentScore;
        this.sentimentCategory = sentimentCategory;
        this.positiveWordCount = positiveWordCount;
        this.negativeWordCount = negativeWordCount;
    }

    public double getSentimentScore() {
        return sentimentScore;
    }

    public SentimentCategory getSentimentCategory() {
        return sentimentCategory;
    }

    public int getPositiveWordCount() {
        return positiveWordCount;
    }

    public int getNegativeWordCount() {
        return negativeWordCount;
    }
}