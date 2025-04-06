package src.queue.workouts;

public class CircularQueue {
    private int[] arr;
    private int size;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public void push(int value) {
        //overflow
        if ((front == 0 && rear == size - 1) || (rear + 1 == front)) {
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
        //rear is the end index of the array - Circular Nature
        if (rear == size - 1 && front != 0) {
            rear = 0;
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
        //front is the end index of the array then front to point start of the index - Circular Nature
        if (front == size - 1) {
            front = 0;
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

    public boolean isEmpty() {
        if (front == -1 && rear == -1)
            return true;
        return false;
    }

    public int getSize() {
        if (isEmpty())
            return 0;
        if (rear > front)
            return rear - front + 1;
        else
            return size - front + rear + 1;
    }

    public void traverse() {
        if (isEmpty())
            return;
        if (rear < front) {
            for (int i = front; i < size; i++)
                System.out.print(arr[i] + " ");
            for (int i = 0; i <= rear; i++)
                System.out.print(arr[i] + " ");
        } else {
            for (int i = front; i <= rear; i++)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
