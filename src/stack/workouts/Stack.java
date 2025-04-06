package src.stack.workouts;

public class Stack {
    int[] arr;
    int size;
    int top;

    Stack(int capacity) {
        arr = new int[capacity];
        size = capacity;
        top = -1;
    }

    void push(int val) {
        if (top == this.size - 1)
            System.out.println("Stack overflow");
        top++;
        arr[top] = val;
    }

    void pop() {
        if (top == -1)
            System.out.println("Stack is empty");
//        arr[top] = -1;// not mandatory
        top--;
    }

    int getSize() {
        return top + 1;
    }

    boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    int getTop() {
        if (top == -1)
            throw new RuntimeException("Empty Stack");
        return arr[top];
    }
}
