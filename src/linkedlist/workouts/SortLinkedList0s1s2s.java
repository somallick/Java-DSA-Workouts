package src.linkedlist.workouts;

import src.linkedlist.workouts.model.Node;

//https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
public class SortLinkedList0s1s2s {

    // one solution
    public static Node segregate_sol1(Node head) {// storing the count of all // easy sol
        // add your code here
        int countOs = 0, count1s = 0, count2s = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0)
                countOs++;
            if (temp.data == 1)
                count1s++;
            if (temp.data == 2)
                count2s++;
            temp = temp.next;
        }
        temp = head;
        //Overwrite the value in the LL
        while (countOs > 0) {
            temp.data = 0;
            temp = temp.next;
            countOs--;
        }
        while (count1s > 0) {
            temp.data = 1;
            temp = temp.next;
            count1s--;
        }
        while (count2s > 0) {
            temp.data = 2;
            temp = temp.next;
            count2s--;
        }
        return head;
    }

    // another solution
    public static Node segregate(Node head) {
        if (head == null || head.next == null)
            return head;

        Node temp = head;
        Node headOs = null;
        Node head1s = null;
        Node head2s = null;

        while (temp != null) {

            Node toMove = temp;
            temp = temp.next;
            toMove.next = null;

            if (toMove.data == 0)
                headOs = insertAtHead(headOs, toMove);
            else if (toMove.data == 1)
                head1s = insertAtHead(head1s, toMove);
            else if (toMove.data == 2)
                head2s = insertAtHead(head2s, toMove);
        }

        Node tailOs = getTail(headOs);
        Node tail1s = getTail(head1s);

        if (headOs != null) {
            if (head1s != null) {
                tailOs.next = head1s;
                tail1s.next = head2s;
            } else {
                tailOs.next = head2s;
            }
            return headOs;
        }
        if (head1s != null) {
            tail1s.next = head2s;
            return head1s;
        }
        return head2s;
    }

    public static Node getTail(Node head) {
        Node temp = head;
        if (temp == null)
            return temp;
        while (temp.next != null)
            temp = temp.next;
        return temp;
    }

    public static Node insertAtHead(Node head, Node toMove) {
        if (head == null)
            head = toMove;
        else {
            toMove.next = head;
            head = toMove;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1,
                new Node(2,
                        new Node(2,
                                new Node(1,
                                        new Node(2,
                                                new Node(0,
                                                        new Node(2,
                                                                new Node(2))))))));
        LLUtility.printLL(head);
        head = segregate(head);
        LLUtility.printLL(head);

    }
}
