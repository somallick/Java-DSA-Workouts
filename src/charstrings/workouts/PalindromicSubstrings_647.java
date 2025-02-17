package src.charstrings.workouts;

//https://leetcode.com/problems/palindromic-substrings
public class PalindromicSubstrings_647 {
    public int countSubstrings(String s) {
        int totalCount = 0;
        for (int center = 0; center < s.length(); center++) {

            //For odd length, center is same
            int i = center, j = center;
            int oddLengthPalindromeStringCount = extendAroundCenterForPalindromeCount(s, i, j);

            //For even length, center is two adjacent index
            i = center; j = center + 1;
            int evenLengthPalindromeStringCount = extendAroundCenterForPalindromeCount(s, i, j);

            totalCount = totalCount + oddLengthPalindromeStringCount + evenLengthPalindromeStringCount;
        }
        return totalCount;
    }

    public int extendAroundCenterForPalindromeCount(String s, int i, int j) {
        int l = s.length();
        int count = 0;
        while (i >= 0 && j < l && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}
