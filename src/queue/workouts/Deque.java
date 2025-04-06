package src.queue.workouts;

public class Deque {
    int[] arr;
    int size;
    int front;
    int rear;

    public Deque(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public void pushFront(int value) {
        //overflow
        if (front == 0) {
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
        front--;
        arr[front] = value;
    }

    public void pushBack(int value) {
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

    public void pollFront() {
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

    public void pollBack() {
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
        rear--;
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

    public void traverse() {
        if (isEmpty())
            return;
        for (int i = front; i <= rear; i++)
            System.out.print(arr[front] + " ");
        System.out.println();
    }
}
