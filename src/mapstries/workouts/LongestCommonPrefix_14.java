package src.mapstries.workouts;

import java.util.Arrays;
import java.util.Map;

//https://leetcode.com/problems/longest-common-prefix
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight", "floor", "fuck"};
        System.out.println(longestCommonPrefix(strs));

    }

    // Best Sol TC - O(nlog n)
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort((strs));
        StringBuilder commonPrefix = new StringBuilder();
        String first = strs[0], last = strs[strs.length - 1];
        int minLength = Math.min(first.length(), last.length());
        for (int i = 0; i < minLength; i++) {
            if (first.charAt(i) != last.charAt(i))
                return commonPrefix.toString();
            commonPrefix.append(first.charAt(i));
        }
        return commonPrefix.toString();
    }

    // Using Trie approach - TC O(n*L) where L is the length of the word in array
    public static String longestCommonPrefix_sol2(String[] strs) {
        TrieNode root = new TrieNode('-');
        for (String str : strs) {
            insertInTrie(root, str);
        }
        TrieNode temp = root;
        TrieNode next = root;
        StringBuilder lcp = new StringBuilder();
        while (!temp.isTerminal && temp.children.size() == 1) {
            for (Map.Entry<Character, TrieNode> child : temp.children.entrySet()) {
                lcp.append(child.getValue().data);
                next = child.getValue();
            }
            temp = next;
        }
        return lcp.toString();
    }

    public static void insertInTrie(TrieNode root, String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.children.containsKey(ch)) {
                TrieNode child = new TrieNode(ch);
                temp.children.put(ch, child);
            }
            temp = temp.children.get(ch);
        }
        temp.isTerminal = true;
    }
}
