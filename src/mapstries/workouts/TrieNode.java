package src.mapstries.workouts;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    public boolean isTerminal;
    public char data;
    public Map<Character, TrieNode> children;

    public TrieNode(char ch) {
        data = ch;
        children = new HashMap<>();
        isTerminal = false;
    }
}