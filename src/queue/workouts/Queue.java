package src.queue.workouts;

public class Queue {
    private int[] arr;
    private int size;
    private int front;
    private int rear;

    public Queue(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public void push(int value) {
        //overflow
        if (rear == size - 1) {
            System.out.println("Overflow");
            return;
        }
        //first element
        if (front == -1 && rear == -1) {
            front++;
            rear++;
            arr[rear] = value;
            return;
        }
        //normal flow
        rear++;
        arr[rear] = value;
    }

    public void poll() {
        //underflow
        if (front == -1 && rear == -1) {
            System.out.println("Underflow");
            return;
        }
        //single element
        if (front == rear) {
            front = -1;
            rear = -1;
            return;
        }
        //normal flow
        front++;
    }

    public int getFront() throws Exception {
        if (isEmpty())
            throw new RuntimeException("Empty Queue");
        else
            return arr[front];
    }

    public int getRear() {
        if (isEmpty())
            throw new RuntimeException("Empty Queue");
        else
            return arr[rear];
    }

    public boolean isEmpty() {
        if (front == -1 && rear == -1)
            return true;
        return false;
    }

    public int getSize() {
        if (isEmpty())
            return 0;
        return (rear - front + 1);
    }
}
