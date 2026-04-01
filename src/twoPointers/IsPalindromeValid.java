package twoPointers;

//Given a string, determine if it's a palindrome after removing all non-alphanumeric characters. A character is alphanumeric if it's either a letter or a number.
//
//Example 1:
//
//Input: s = 'a dog! a panic in a pagoda.'
//Output: True
//Example 2:
//
//Input: s = 'abc123'
//Output: False


public class IsPalindromeValid {
    public static Boolean is_palindrome_valid(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // Skip non-alphanumeric characters from the left.
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters from the right.
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // If the characters at the left and right pointers don’t match, the string is
            // not a palindrome.
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abc123";
        System.out.println(is_palindrome_valid(input));
    }
}
