import java.util.Scanner;

public class FindLongestPalindrome {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(longestPalindromeString(input));
    }

    public static String expand(String s, int low, int high) {

        /*Equality is checked starting from
          the center moving one character left and one character
          right from the center. If both chars are equal then the
          next set of chars are checked.*/


        while (low >= 0 && high < s.length()
                && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        return s.substring(low + 1, high);
    }

    public static String longestPalindromeString(String s) {
        if (s.length() == 0) {   // Validation
            return null;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            // get longest palindrome with odd (center is i)
            String palindrome = expand(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }// get longest palindrome with two numbers (center is i, i+1)
            palindrome = expand(s, i, i + 1);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }

}

