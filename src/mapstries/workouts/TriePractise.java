package src.mapstries.workouts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TriePractise {

    //insert by iterative
    public static void insertIntoTrie(TrieNode root, String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.children.containsKey(ch)) {
                //absent
                TrieNode child = new TrieNode(ch);
                temp.children.put(ch, child);
            }
            temp = temp.children.get(ch);
        }
        temp.isTerminal = true;
    }

    public static boolean searchFromTrie(TrieNode root, String word) {

        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.children.containsKey(ch)) {
                //not present
                return false;
            }
            temp = temp.children.get(ch);
        }
        return temp.isTerminal;
    }

    public static void deleteFromTrie(TrieNode root, String word) {

        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.children.containsKey(ch)) {
                //not present
                return;
            }
            temp = temp.children.get(ch);
        }
        temp.isTerminal = false;
    }

    public static boolean startsWith(TrieNode root, String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!temp.children.containsKey(ch)) {
                //not present
                return false;
            }
            temp = temp.children.get(ch);
        }
        return true;
    }

    public static void findWordsFromPrefix(TrieNode root, String prefix) {
        TrieNode temp = root;
        //traverse till the prefix last character
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!temp.children.containsKey(ch)) {
                //not present
                return;
            }
            temp = temp.children.get(ch);
        }
        // as reached the last character node of prefix in trie
        // now store the all the words with prefix
        List<String> finalWordList = new ArrayList<>();
        String output = prefix;
        storeSuggestedWord(temp, finalWordList, output);
        for (String word : finalWordList)
            System.out.println(word);
    }

    private static void storeSuggestedWord(TrieNode root, List<String> words, String output) {
        if (root.isTerminal) { //B.C
            words.add(output);
            // don't return else the other characters will not be considered after current character node
        }
        for (Map.Entry<Character, TrieNode> child : root.children.entrySet()) {
            // stored one character
            output = output + child.getValue().data;
            //rest recursion will handle
            storeSuggestedWord(child.getValue(), words, output);
            // removing the last character
            output = output.substring(0, output.length() - 1);
        }
    }

    //insert by recursion
    public static void insertIntoTrieUsingRE(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }
        char ch = word.charAt(0);
        TrieNode child;
        if (root.children.containsKey(ch)) {
            //present
            child = root.children.get(ch);
        } else {
            //absent
            child = new TrieNode(ch);
            root.children.put(ch, child);
        }
        insertIntoTrieUsingRE(child, word.substring(1));
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode('-');
        insertIntoTrie(root, "geeks");
        insertIntoTrie(root, "gear");
        insertIntoTrie(root, "rafale");
        System.out.println(searchFromTrie(root, "geeks") + " ");
        System.out.println(searchFromTrie(root, "rafale") + " ");
        System.out.println(searchFromTrie(root, "game") + " ");
        System.out.println(searchFromTrie(root, "gear") + " ");
        deleteFromTrie(root, "gear");
        System.out.println("----------------------------------------");
        System.out.println(searchFromTrie(root, "geeks") + " ");
        System.out.println(searchFromTrie(root, "gear") + " ");
        System.out.println("----------------------------------------");
        TrieNode root2 = new TrieNode('-');
        insertIntoTrie(root2, "baby");
        insertIntoTrie(root2, "baba");
        insertIntoTrie(root2, "bablu");
        insertIntoTrie(root2, "balu");
        findWordsFromPrefix(root2, "bab");


    }
}
