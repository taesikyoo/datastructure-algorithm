package section8;

import java.util.function.Function;

public class isPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindromeHelper("amanaplanacanalpanama"));
        System.out.println(isPalindromeHelper("amanaplanacanalpandemonium"));
    }

    private static boolean isPalindrome(String s) {
        if (s.equals("") || s.length() == 1) {
            return true;
        }

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        return false;
    }

    private static boolean isPalindromeHelper(String s) {
        if (s.equals("") || s.length() == 1) {
            return true;
        }

        Function<String, Boolean> helper = (stringInput) -> {
            if (stringInput.charAt(0) == stringInput.charAt(stringInput.length() - 1)) {
                return isPalindrome(stringInput.substring(1, stringInput.length() - 1));
            }
            return false;
        };

        return helper.apply(s);
    }
}
