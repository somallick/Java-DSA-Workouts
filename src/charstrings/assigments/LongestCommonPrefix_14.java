package src.charstrings.assigments;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-prefix
public class LongestCommonPrefix_14 {

    // TC - O(nlog n)
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder common = new StringBuilder();
        String first = strs[0], last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return common.toString();
            }
            common.append(first.charAt(i));
        }
        return common.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight", "floo", "fuck"};
        System.out.println(longestCommonPrefix(strs));

    }

    // brute force O(n^2)
    public String longestCommonPrefix_sol2(String[] strs) {

        String pStr = strs[0], prefix = "";
        for (int i = 1; i <= pStr.length(); i++) {
            String s = pStr.substring(0, i);
            boolean flag = true;
            for (String string : strs) {
                if (string.indexOf(s) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true)
                prefix = s;

        }
        return prefix;
    }
}
