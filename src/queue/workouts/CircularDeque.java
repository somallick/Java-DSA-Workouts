package src.queue.workouts;

public class CircularDeque {
    private int[] arr;
    private int size;
    private int front;
    private int rear;

    public CircularDeque(int size) {
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public void pushFront(int value) {
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
        //front is the Oth index of the array - Circular Nature
        if (front == 0 && rear != size - 1) {
            front = size - 1;
            arr[front] = value;
            return;
        }
        //normal flow
        front--;
        arr[front] = value;
    }

    // Same as Circular Queue push
    public void pushBack(int value) {
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

    // Same as Circular Queue poll
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
        //front is the end index of the array then front to point start of the index - Circular Nature
        if (front == size - 1) {
            front = 0;
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
        //rear is the 0th index of the array then rear will point to end array index - Circular Nature
        if (rear == 0) {
            rear = size - 1;
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

    public int getFront() throws Exception {
        if (isEmpty())
            throw new RuntimeException("Empty Queue");
        else
            return arr[front];
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
