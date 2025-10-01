package src.recursion.assignment;

//https://www.geeksforgeeks.org/dsa/recursive-function-check-string-palindrome
public class PalindromeCheckRE {
    public static boolean check(String str, int start, int end) {
        if (start > end)
            return true;
        if (str.charAt(start) != str.charAt(end))
            return false;
        return check(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String str = "azxivixza";
        System.out.println(check(str, 0, str.length() - 1));
    }
}
