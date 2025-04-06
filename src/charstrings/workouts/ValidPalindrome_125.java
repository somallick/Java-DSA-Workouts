package src.charstrings.workouts;

//https://leetcode.com/problems/valid-palindrome
public class ValidPalindrome_125 {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            if (arr[i] != arr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome_sol2(String s) {
        if (s.isEmpty())
            return true;
        char[] charArr = s.toCharArray();
        int start = 0;
        int last = charArr.length - 1;
        while (start <= last) {
            char currFirst = charArr[start];
            char currLast = charArr[last];
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome_sol2(s));
    }
}
