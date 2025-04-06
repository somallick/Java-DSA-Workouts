package src.stack.workouts;

import java.util.Stack;

public class StackPractise {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

//        System.out.println(stack.size());
//        System.out.println(stack.empty());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.isEmpty());

//        System.out.println(findMiddleValue(stack, stack.size(), 0));
//        findMiddleValue2(stack, stack.size(), 0);
//        insertAtBottom(stack, 12,stack.size(),0);
//        traverse(stack);

//        System.out.println(checkSorted(stack, Integer.MAX_VALUE));
//        traverse(stack);

//        traverse(stack);
//        reverseStack(stack);
//        traverse(stack);

        traverse(stack);
        sortedInsert(stack, 5);
        traverse(stack);

    }

//    public static void traverseByLoop(Stack stack) {
//        while (!stack.empty()) {
//            System.out.print(stack.pop() + " ");
//        }
//        System.out.println();
//    }
    public static<T> void traverseByLoop(Stack<T> stack) {
        for (T s: stack) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void traverse(Stack<Integer> stack) {
        if (stack.empty()) {
            System.out.println();
            return;
        }
        int value = stack.pop();
        System.out.print(value + " ");
        traverse(stack);
        stack.push(value);

    }

    //stack structure is maintained
    public static int findMiddleValue(Stack<Integer> stack, int size, int count) {
        int mid = 0;
        if (count == (size / 2)) {
            return stack.peek();
        }
        // store the pop value
        int value = stack.pop();
        //recursion
        mid = findMiddleValue(stack, size, count + 1);
        //backtrack
        stack.push(value);
        return mid;
    }

    public static void findMiddleValue2(Stack<Integer> stack, int size, int count) {
        int mid = 0;
        if (count == (size / 2)) {
            System.out.println(stack.peek()); // middle element
            return;
        }
        // store the pop value
        int value = stack.pop();
        //recursion
        findMiddleValue2(stack, size, count + 1);
        //backtrack
        stack.push(value);
    }

    public static void insertAtBottom(Stack<Integer> stack, int value, int size, int count) {
        if (count == size) {
            stack.push(value);
            return;
        }
        int popValue = stack.pop();
        insertAtBottom(stack, value, size, count + 1);
        stack.push(popValue);
    }

    public static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.empty()) {
            stack.push(value);
            return;
        }
        int popValue = stack.pop();
        insertAtBottom(stack, value);
        stack.push(popValue);
    }

    public static boolean checkSorted(Stack<Integer> stack) {// stack will be empty after this func
        Integer prev = Integer.MAX_VALUE;
        while (!stack.empty()) {
            Integer top = stack.pop();
            if (prev < top)
                return false;
            prev = top;
        }
        return true;
    }

    public static boolean checkSorted(Stack<Integer> stack, int prev) {// stack will be intact after this func
        if (stack.empty())
            return true;
        int curr = stack.pop();
        if (curr > prev) {
            stack.push(curr);
            return false;
        }
        prev = curr;
        boolean check = checkSorted(stack, prev);
        stack.push(curr);
        return check;
    }

    public static Stack<Integer> reverseStackByLoop(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<>();
        while (!stack.empty()) {
            stack1.push(stack.pop());
        }
        return stack1;
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int value = stack.pop();
        // recursion
        reverseStack(stack);
        // while backtracking pushing each value at the bottom of the stack i.e. reverse order
        insertAtBottom(stack, value);
    }

    public static void sortedInsert(Stack<Integer> sortedStack, int value) {
        // stack empty - actual empty or at insert will at the bottom
        if (sortedStack.empty() || value > sortedStack.peek()) {
            sortedStack.push(value);
            return;
        }
        int popValue = sortedStack.pop();
        sortedInsert(sortedStack, value);
        sortedStack.push(popValue);
    }
}
