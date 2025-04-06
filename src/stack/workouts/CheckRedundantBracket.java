package src.stack.workouts;

import java.util.Stack;

//https://www.geeksforgeeks.org/problems/expression-contains-redundant-bracket-or-not/1
public class CheckRedundantBracket {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> refStack = new Stack<>();
        Boolean isOpsPresent = false;
        int redundantCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (str == '(') {
                refStack.push(str);
            } else if (str == '+' || str == '-' || str == '*' || str == '/') {
                refStack.push(str);
            } else if (str == ')') {
                isOpsPresent = false;
                while (!refStack.empty() && !refStack.peek().equals('(')) {
                    isOpsPresent = true;
                    refStack.pop();
                }
                refStack.pop(); // popping the top '('
                if (isOpsPresent == false)
                    redundantCount++;
            }
        }
        return (redundantCount > 0) ? 1 : 0;
    }
}
