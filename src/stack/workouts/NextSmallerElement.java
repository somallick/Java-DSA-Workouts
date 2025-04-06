package src.stack.workouts;

import java.util.*;
import java.util.Stack;

//https://www.geeksforgeeks.org/next-smaller-element
public class NextSmallerElement {
    public static List<Integer> findNextSmallerElement(List<Integer> arr) {
        Stack<Integer> tracker = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int n = arr.size();
        tracker.push(-1);
        //traversing from right
        for (int i = n - 1; i >= 0; i--) {
            int element = arr.get(i);
            while (element <= tracker.peek()) {
                tracker.pop();
            }
            result.add(0, tracker.peek()); // insert from front
            tracker.push(element);
        }
        return result;
    }

    public static void main(String[] args) {
        // Input list
        List<Integer> arr = Arrays.asList(4, 8, 2, 1, 6, 10, 5);

        // Function call to find next smaller elements
        List<Integer> result = findNextSmallerElement(arr);

        // Print the original list
        System.out.println("Original List: " + arr);

        // Print the next smaller elements
        System.out.println("Next Smaller Elements: " + result);
    }
}
