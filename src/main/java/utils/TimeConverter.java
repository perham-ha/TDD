package utils;

public class TimeConverter {
    private static final int SECONDS_PER_MINUTE = 60;

    public double secondsToMinutes(long seconds) {
        return (double) seconds / SECONDS_PER_MINUTE;
    }
}
