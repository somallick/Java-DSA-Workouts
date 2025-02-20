package src.charstrings.workouts;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/decode-the-message
public class DecodeTheMessage_2325 {

    public static String decodeMessage(String key, String message) {
        key = key.replaceAll(" ","");
        char charSeq = 'a';
        StringBuilder decodedMsg = new StringBuilder();
        Map<Character, Character> decoder = new HashMap<>();
        decoder.put(' ', ' ');
        for(int i=0; i<key.length(); i++) {
            char decode = key.charAt(i);
            if (!decoder.containsKey(decode))
                decoder.put(decode, charSeq++);
        }
        for(int i=0; i<message.length(); i++){
            decodedMsg = decodedMsg.append(String.valueOf(decoder.get(message.charAt(i))));
        }
        return decodedMsg.toString();
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key, message));
    }
}
