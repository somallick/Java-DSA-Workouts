package src.charstrings.assigments;

import java.util.Set;

//https://leetcode.com/problems/reverse-vowels-of-a-string
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char[] ar = s.toCharArray();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        while (start < end) {
            if (!vowels.contains(Character.toLowerCase(ar[start])))
                start++;
            else if (!vowels.contains(Character.toLowerCase(ar[end])))
                end--;
            else {
                char temp = ar[start];
                ar[start] = ar[end];
                ar[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(ar);
    }

    // little optimised runtime
    public String reverseVowels_sol2(String s) {
        int start = 0, end = s.length() - 1;
        char[] ar = s.toCharArray();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        while (start < end) {
            while (start < end && !vowels.contains(Character.toLowerCase(ar[start])))
                start++;
            while (start < end && !vowels.contains(Character.toLowerCase(ar[end])))
                end--;
            if( start < end) {
                char temp = ar[start];
                ar[start] = ar[end];
                ar[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(ar);
    }
}
