package src.stack.workouts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1
public class PrevSmallerElement {
    public static List<Integer> leftSmaller(int n, int a[]) {
        Stack<Integer> tracker = new Stack<>();
        List<Integer> result = new ArrayList<>();
        tracker.push(-1);
        //traversing from left
        for (int i = 0; i < n; i++) {
            int element = a[i];
            while (element <= tracker.peek()) {
                tracker.pop();
            }
            result.add(tracker.peek());
            tracker.push(element);
        }
        return result;
    }
}
