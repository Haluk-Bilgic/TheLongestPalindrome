import java.util.Scanner;

public class FindLongestPalindrome {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(longestPalindromeString(input));
    }

    public static String expand(String s, int low, int high) {

        while (low >= 0 && high < s.length()
                && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        return s.substring(low + 1, high);
    }

    public static String longestPalindromeString(String s) {
        if (s.length() == 0) {
            return null;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {

            String palindrome = expand(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
            palindrome = expand(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }

}

