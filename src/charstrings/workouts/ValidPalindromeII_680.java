package src.charstrings.workouts;

//https://leetcode.com/problems/valid-palindrome-ii
public class ValidPalindromeII_680 {

    public static boolean validPalindrome(String s) {
        int l = s.length();
        int start= 0, end =l-1;
        while (start<=end) {
            if(s.charAt(start)!=s.charAt(end)){
                if(isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1))
                    return true;
                else
                    return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalindrome(String s, int start, int end) {
        while (start<=end) {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    //using charArray (Slower than charAt)
    public static boolean validPalindrome_1(String s) {
        char[] charArray= s.toCharArray();
        int l = s.length();
        int start= 0, end =l-1;
        while (start<=end) {
            if(charArray[start]!=charArray[end]){
                if(isPalindrome_1(charArray, start+1, end) || isPalindrome_1(charArray, start, end-1))
                    return true;
                else
                    return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalindrome_1(char[] charArray, int start, int end) {
        while (start<=end) {
            if(charArray[start]!=charArray[end])
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbcc";
        System.out.println(validPalindrome(s));
    }
}
