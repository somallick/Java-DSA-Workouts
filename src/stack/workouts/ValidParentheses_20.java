package src.stack.workouts;

import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses
public class ValidParentheses_20 {
    public static boolean isValid(String s) { // TC - O(n) SC - O(n)
        Stack<Character> refStack = new Stack<>();
        Map<Character, Character> refMap = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '[')
                //open bracket scenario
                refStack.push(bracket);
            else {
                // close bracket scenario
                char openBracket = refMap.get(bracket); // getting the open bracket for that close bracket
                if (refStack.empty())
                    return false;
                if (refStack.peek().equals(openBracket)) {
                    refStack.pop();
                } else
                    return false;
            }
        }
        if (!refStack.empty())
            return false;
        return true;
    }
}
