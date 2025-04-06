package src.charstrings.assigments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-anagram
public class ValidAnagram_242 {

    public static boolean isAnagram(String s, String t) { // O(n log n)
        if (s.length() != t.length())
            return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        if (!Arrays.equals(sArr, tArr))
            return false;
        return true;
    }

    public static boolean isAnagram_sol2(String s, String t) { //O(n)
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> anagramMap = new HashMap<>();

        //Add frequency of alphabet
        for (int i = 0; i < s.length(); i++)
            anagramMap.put(s.charAt(i), anagramMap.getOrDefault(s.charAt(i), 0) + 1);
        //Remove frequency of alphabet
        for (int i = 0; i < t.length(); i++)
            anagramMap.put(t.charAt(i), anagramMap.getOrDefault(t.charAt(i), 0) - 1);

        for (var pair : anagramMap.entrySet())
            if (pair.getValue() != 0)
                return false;
        return true;
    }
}
