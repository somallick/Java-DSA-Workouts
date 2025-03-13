package src.charstrings.assigments;

// https://leetcode.com/problems/reverse-only-letters
public class ReverseOnlyLetters_917 {
    public String reverseOnlyLetters(String s) {
        int start = 0, end = s.length() - 1;
        char[] ar = s.toCharArray();
        while (start < end) {
            if (!Character.isLetter(ar[start]))
                start++;
            else if (!Character.isLetter(ar[end]))
                end--;
            else {
                char temp = ar[start];
                ar[start] = ar[end];
                ar[end] = temp;
                start++;
                end--;
            }
        }
//        StringBuilder sb = new StringBuilder();
//        return sb.append(ar).toString();
        return String.valueOf(ar);
    }
}
