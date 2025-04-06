package src.linkedlist.workouts.model;

// Definition of a Node in a singly linked list
public class Node {
    public int data;
    public Node next;

    // Constructor to initialize the node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node nextNode) {
        this.data = data;
        this.next = nextNode;
    }
}
