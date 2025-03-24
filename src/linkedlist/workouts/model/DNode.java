package src.linkedlist.workouts.model;

// Definition of a Node in a doubly linked list
public class DNode {
    public int data;
    public DNode prev;
    public DNode next;

    public DNode(int d) {
        data = d;
        prev = next = null;
    }
}
