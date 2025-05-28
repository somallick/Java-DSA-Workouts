package src.mapstries.workouts;

import java.util.*;

//https://leetcode.com/problems/group-anagrams
public class GroupAnagrams_49 {

    // TC- O(N∗MLogM)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedStr = sortString(str);
            List<String> temp = map.getOrDefault(sortedStr, new ArrayList<>());
            temp.add(str);
            map.put(sortedStr, temp);
        }
        for (List<String> list : map.values())
            finalList.add(list);
        return finalList;
    }

    private String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
