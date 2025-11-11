package utils;

public class StringProcessor {

    public String reverse(String str) {
        // Avoiding NullPointerException
        if (str == null) {
            return null;
        }

        // Strings with 0 or 1 characters remain unchanged
        if (str.length() <= 1) {
            return str;
        }

        // Create StringBuilder object with string parameter
        StringBuilder originalString = new StringBuilder(str);

        // Reverse string with built-in `reverse()` method
        originalString.reverse();

        // Convert StringBuilder object back to a String (I assume we require String
        // New variable for clarity and easier future handling
        String reversedString = originalString.toString();

        // Constructs and returns a new String from the newly reversed char array
        return reversedString;
    }
}
