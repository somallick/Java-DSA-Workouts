package src.queue.workouts;

public class ManualQueuePractise {
    public static void main(String[] args) throws Exception {
        // Circular Queue Test
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.push(1);
        circularQueue.push(2);
        circularQueue.push(3);
        circularQueue.push(4);
        circularQueue.push(5);
        circularQueue.traverse();
        circularQueue.push(10);
        circularQueue.poll();
        circularQueue.poll();
        circularQueue.push(10);
        circularQueue.traverse();
        circularQueue.poll();
        circularQueue.poll();
        circularQueue.poll();
        circularQueue.traverse();
        circularQueue.push(20);
        circularQueue.traverse();
        circularQueue.poll();
        circularQueue.traverse();
        circularQueue.poll();
        circularQueue.poll();
        circularQueue.traverse();

        System.out.println("-----------------------------------");

        // Circular Deque Test
        CircularDeque circularDeque = new CircularDeque(5);
        circularDeque.pushBack(1);
        circularDeque.pushBack(2);
        circularDeque.pushBack(3);
        circularDeque.pushBack(4);
        circularDeque.pushBack(5);
        circularDeque.traverse();
        circularDeque.pushFront(10);
        circularDeque.pollFront();
        circularDeque.traverse();
        circularDeque.pushFront(10);
        circularDeque.traverse();
        circularDeque.pollBack();
        circularDeque.pushFront(10);
        circularDeque.traverse();
    }
}
