package src.charstrings.workouts;

import java.util.*;

//https://leetcode.com/problems/custom-sort-string
public class CustomSortString_791 {
    public static String customSortString1(String order, String s) {
        List<Character> str = new ArrayList<>();
        for(int i=0; i<s.length(); i++)
            str.add(s.charAt(i));
//        Collections.sort(str, (o1, o2) -> order.indexOf(o1)-order.indexOf(o2));
        Collections.sort(str, Comparator.comparingInt(order::indexOf));
        StringBuilder finalString = new StringBuilder();
        for(Character c : str)
            finalString = finalString.append(c);
        return finalString.toString();
    }

    public static void main(String[] args) {

    }
}
