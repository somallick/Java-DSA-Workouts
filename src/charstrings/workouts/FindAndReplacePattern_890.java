package src.charstrings.workouts;

import java.util.*;

//https://leetcode.com/problems/find-and-replace-pattern
public class FindAndReplacePattern_890 {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> finalPatternWords = new ArrayList<>();
        String normalisePattern = normaliseToSinglePattern(pattern);
        for(int i=0; i< words.length; i++) {
            String normaliseWord = normaliseToSinglePattern(words[i]);
            if(normaliseWord.equals(normalisePattern))
                finalPatternWords.add(words[i]);
        }
        return finalPatternWords;
    }
    public static String normaliseToSinglePattern (String pattern) {
        Map<Character, Character> normaliser = new HashMap<>();
        StringBuilder normalisePattern = new StringBuilder();
        char charSeq = 'a';
        for(int i=0; i<pattern.length(); i++){
            char pat = pattern.charAt(i);
            if(normaliser.containsKey(pat)){
                normalisePattern.append(normaliser.get(pat));
            }
            else{
                normaliser.put(pat,charSeq);
                normalisePattern.append(charSeq);
                charSeq++;
            }
        }
        return normalisePattern.toString();
    }

    public static List<String> findAndReplacePattern_sol2(String[] words, String pattern) {
        int patLen = pattern.length();
        List<String> matchedWord = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != patLen)
                continue;
            Map<Character, Character> checker = new HashMap<>();
            boolean patternMatched = true;
            for (int j = 0; j < patLen; j++) {
                char pat = pattern.charAt(j);
                if ((checker.containsKey(pat) && checker.get(pat) != words[i].charAt(j)) || (!checker.containsKey(pat) && checker.containsValue(words[i].charAt(j)))) {
                    patternMatched = false;
                    break;
                } else
                    checker.put(pat, words[i].charAt(j));
            }
            if (patternMatched)
                matchedWord.add(words[i]);

        }
        return matchedWord;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        findAndReplacePattern(words, pattern).stream().forEach(e -> System.out.println(e));
    }
}
