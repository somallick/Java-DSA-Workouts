package src.queue.workouts;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueuePractise {

    public static <T> void traversal(Queue<T> queue) {
        for (T q: queue) {
            System.out.print(q + " ");
        }
        System.out.println();
    }

    public static <T> void reverse(Queue<T> queue) {
        if (queue.isEmpty())
            return;
        T value = queue.poll();
        reverse(queue); //recursion
        queue.add(value); //backtrack
    }
    public static <T> void reverseUsingStack(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.poll());
        while(!stack.isEmpty())
            queue.add(stack.pop());
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(14);
        queue.add(15);
        queue.add(16);
//        System.out.println(queue.peek());
//        System.out.println(queue.size());
//        System.out.println(queue.isEmpty());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
        traversal(queue);
        reverse(queue);
        traversal(queue);
        reverseUsingStack(queue);
        traversal(queue);
    }
}
