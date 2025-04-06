package src.stack.workouts;

public class Stack2in1 {
    private int[] arr;
    private int size;
    private int top1;
    private int top2;

    Stack2in1(int size) {
        this.size = size;
        arr = new int[this.size];
        this.top1 = -1;
        this.top2 = this.size;
    }

    public boolean isEmptyStack1() {
        if (top1 == -1)
            return true;
        return false;
    }

    public boolean isEmptyStack2() {
        if (top2 == size)
            return true;
        return false;
    }

    public void push1(int val) {
        if (top2 - top1 == 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top1++;
        arr[top1] = val;
    }

    public void push2(int val) {
        if (top2 - top1 == 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top2--;
        arr[top2] = val;
    }

    public void pop1() {
        if (top1 == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        top1--;
    }

    public void pop2() {
        if (top2 == size) {
            System.out.println("Stack Underflow");
            return;
        }
        top2++;
    }

    public void print() {
        if (isEmptyStack1() && isEmptyStack2()) {
            System.out.println("Empty Full Stack");
            return;
        }
        for (int a : arr)
            System.out.print(a + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Stack2in1 stack = new Stack2in1(5);
        stack.pop1();
        stack.print();
        stack.pop2();
        stack.print();
        stack.push1(1);
        stack.print();
        stack.push1(2);
        stack.print();
        stack.push2(3);
        stack.print();
        stack.push1(4);
        stack.print();
        stack.push2(5);
        stack.print();
        stack.push2(5);
        stack.print();

    }

}
