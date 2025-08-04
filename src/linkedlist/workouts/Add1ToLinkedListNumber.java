package src.linkedlist.workouts;

import src.linkedlist.workouts.model.Node;

//https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/0
public class Add1ToLinkedListNumber {
    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public Node addOne(Node head) {
        // code here.
        head = reverseLL(head);
        Node temp = head;
        int carry = 1; // Taking initial carry as 1 that is the value that need to add up in question
        while (temp != null) {
            int sum = carry + temp.data;
            int digit = sum % 10;
            carry = sum / 10;
            temp.data = digit;
            // this is the case for last node as if sum has carry
            // then new node need to create for that value and attach to LL
            if (temp.next == null && carry != 0) {
                Node newNode = new Node(carry);
                temp.next = newNode;
                temp = temp.next;
            }
            temp = temp.next;
        }
        head = reverseLL(head);
        return head;
    }
}
