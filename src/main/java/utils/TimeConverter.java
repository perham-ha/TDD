package utils;

public class TimeConverter {
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MINUTES_PER_HOUR = 60;


    private void validateNonNegative(double value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be negative");
        }
    }

    public double secondsToMinutes(long seconds) {
        validateNonNegative(seconds, "seconds");
        return (double) seconds / SECONDS_PER_MINUTE;
    }

    public double minutesToHours(long minutes) {
        return (double) minutes / MINUTES_PER_HOUR;
    }

    public long minutesToSeconds(double minutes) {
        validateNonNegative(minutes, "minutes");
        return Math.round(minutes * SECONDS_PER_MINUTE);
    }

}
