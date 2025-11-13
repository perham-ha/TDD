package utils;


import java.util.regex.Pattern;

/*
* StringProcessor class that gives functionality in handling Strings
* Commentary is excessive as this is a tutorial course and I wish to
* make revisits easier.
*/
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
        // New variable for clarity
        String reversedString = originalString.toString();

        // Constructs and returns a new String from the newly reversed char array
        return reversedString;
    }

    // Palindrome detection method using existing `reverse()` method
    public boolean isPalindrome(String str) {
        // Empty strings and strings with <=1 characters are considered palindromes
        if (str == null || str.length() <= 1) {
            return true;
        }

        // Convert string to lower case & replace non-alphanumerical characters
        // replaceAll() method uses regex matching all not upper-case/lower-case/digit, due to ^(negate)
        // A-Z might not be needed due to `toLowerCase` but is left as a safety measurement
        // ref.
        // https://stackoverflow.com/questions/1805518/replacing-all-non-alphanumeric-characters-with-empty-strings
        String lowerCaseString = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        // Returns boolean comparison to reversed string with `equals()` method
        return lowerCaseString.equals(reverse(lowerCaseString));
    }

    // Compression method for Strings
    public String compress(String str) {
        // Converts null into empty strings for safety
        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder compressedString = new StringBuilder();
        char previous = str.charAt(0);
        int count = 1;

        // For-loop to compress String based on comparison
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            // Compares if current & previous match and updated counter
            if (current == previous) {
                count++;
            }

            // Else letter and counter are appended, previous is set to current value and count is reset
            else {
                compressedString.append(previous).append(count);

                // In case compressedString reaches str length during compression
                if(compressedString.length() >= str.length()) {return str;}
                previous = current;
                count = 1;
            }
        }

        // One final append to include last number
        compressedString.append(previous).append(count);

        // Uses ternary operator to control which String to return
        // Just as a note to anyone reading the code, it works like below:
        // Condition(True/False) ? resultIfTrue : resultIfFalse
        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }

    public int countWords(String str) {
        if (str == null || str.isBlank()) {
            return 0;
        }

        // The regex will match one or more whitespace characters
        // ref. https://www.baeldung.com/java-regex-s-splus
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    // Pattern ref. https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
    // Regex ref. https://www.regular-expressions.info/email.html
    private static final Pattern EMAIL_PATTERN = Pattern.compile (
            "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b",
            Pattern.CASE_INSENSITIVE
    );

    public boolean isValidEmail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }

        return EMAIL_PATTERN.matcher(email).matches();
    }

    public String capitalizeWords(String str) {
        if (str == null || str.isBlank()) {
            return str;
        }

        // Remove leading/trailing whitespaces and split on one or more whitespace characters
        // Multiple spaces, tabs, or newlines are treated as single separator
        String[] initialWords = str.trim().split("\\s+");

        // Used for easier and more efficient handling of words (SB object)
        StringBuilder capitalizedWords = new StringBuilder();

        // Iterate through each extracted word
        for (int i = 0; i < initialWords.length; i++) {
            String word = initialWords[i];

            // Capitalize the first character of the word
            capitalizedWords.append(Character.toUpperCase(word.charAt(0)));

            // Append remaining characters, in the case of more than 1 character words
            if (word.length() > 1) {
                capitalizedWords.append(word.substring(1));
            }

            // Append space only between words, not after last one (avoid trailing space
            if (i < initialWords.length -1) {
                capitalizedWords.append(" ");
            }
        }

        // Return the combined capitalized string
        return capitalizedWords.toString();
    }

    public boolean containsSubstring(String str, String substring) {
        if (str == null || str.isEmpty() || substring == null ||  substring.isEmpty()) {
            return false;
        }
        return str.toLowerCase().contains(substring.toLowerCase());
    }
}
