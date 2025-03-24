package src.linkedlist.workouts;

import src.linkedlist.workouts.model.Node;

public class SinglyLinkedListPractise {

    public static void traverseList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static boolean searchInAList(int value, Node head) {
        Node temp = head;
        while (temp != null) {
            if (value == temp.data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static int getListLength(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static Node insertAtHead(int value, Node head) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node insertAtTail(int value, Node head) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        return head;
    }

    public static Node insertAtTail(int value, Node head, Node tail) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return head;
        }
        tail.next = newNode;
        tail = newNode;
        return head;
    }

    public static Node insertAtPosition(int value, int position, Node head) {
        if (position < 1)
            return head;
        if (position == 1)
            return insertAtHead(value, head);
        Node temp = head;
        int p = 1;
        while (p < position - 1 && temp != null) {
            temp = temp.next;
            p++;
        }
        if (temp == null)
            return head;
        if (temp.next == null)
            return insertAtTail(value, head, temp);

        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static Node deleteAtPosition(int position, Node head) {
        Node temp = head;
        Node prevNode = null;

        if (head == null)
            return head;

        if (position == 1) {
            head = head.next;
            return head;
        }
        int p = 1;
        while (p < position && temp != null) {
            prevNode = temp;
            temp = temp.next;
            p++;
        }
        if (temp == null)
            return head;
        prevNode.next = temp.next;
        temp.next = null;
        return head;
    }

    public static Node deleteValueFromLL(int value, Node head) {
        Node temp = head;
        Node prevNode = null;

        if (head == null)
            return head;

        if (head.data == value) {
            head = head.next;
            return head;
        }

        while (temp != null && temp.data != value) {
            prevNode = temp;
            temp = temp.next;
        }
        if (temp == null)
            return head;
        prevNode.next = temp.next;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(20);
        Node tail = head;
        traverseList(head);
        head = insertAtHead(10, head);
        traverseList(head);
        head = insertAtTail(30, head, tail);
        traverseList(head);
        head = insertAtTail(40, head, tail);
        traverseList(head);
        head = insertAtPosition(50, 4, head);
        traverseList(head);
        int searchValue = 30;
        System.out.println(searchInAList(searchValue, head));
        head = deleteAtPosition(3, head);
        traverseList(head);
        head = deleteValueFromLL(40, head);
        traverseList(head);

    }
}
