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
}
