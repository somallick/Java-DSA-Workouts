package src.queue.workouts;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
public class StreamFirstNonRepeating {
    public static String FirstNonRepeating(String s) {
        // code here
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> freqMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
                queue.add(ch);
            }

            while (!queue.isEmpty() && freqMap.get(queue.peek()) > 1)
                queue.poll();

            if (queue.isEmpty())
                result = result.append("#");
            else
                result = result.append(queue.peek());
        }
        return result.toString();
    }
}
