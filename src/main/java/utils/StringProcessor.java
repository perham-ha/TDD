package utils;

public class StringProcessor {

    public String reverse(String str) {
        // Strings with 0 or 1 characters remain unchanged
        if (str.length() <= 1) {
            return str;
        }

        // Converting String (immutable) to array of characters
        char[] characters = str.toCharArray();

        // Initializing two pointers as start and end of array
        int start = 0;
        int end = characters.length - 1;

        // Swap characters from end to start
        while (start < end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }

        // Constructs and returns a new String from the newly reversed char array
        return new String(characters);
    }
}
