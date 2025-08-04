package src.mapstries.workouts;

//https://leetcode.com/problems/implement-trie-prefix-tree
public class ImplementTrie_208 {

    public static void main(String[] args) {
        String word = "geeky", searchWord = "geek", prefix = "gee";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(searchWord);
        boolean param_3 = obj.startsWith(prefix);
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('-');
    }

    public void insert(String word) {
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

    public boolean search(String word) {
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

    public boolean startsWith(String prefix) {
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
}
