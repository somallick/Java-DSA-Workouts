package src.linkedlist.workouts;

import src.linkedlist.workouts.model.DNode;

public class DoublyLinkedListPractise {

    public static void traverseList(DNode head) {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void traverseListBothWay(DNode head) {
        DNode temp = head;
        DNode prevDNode = null;
        while (temp != null) {
            System.out.print(temp.data + "->");
            prevDNode = temp;
            temp = temp.next;
        }
        System.out.print("NULL || ");
        while (prevDNode != null) {
            System.out.print(prevDNode.data + "->");
            prevDNode = prevDNode.prev;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static boolean searchInAList(int value, DNode head) {
        DNode temp = head;
        while (temp != null) {
            if (value == temp.data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static int getListLength(DNode head) {
        int length = 0;
        DNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static DNode insertAtHead(int value, DNode head) {
        DNode newDNode = new DNode(value);
        if (head == null) {
            head = newDNode;
            return head;
        }
        newDNode.next = head;
        head.prev = newDNode;
        head = newDNode;
        return head;
    }

    public static DNode insertAtTail(int value, DNode head) {
        DNode newDNode = new DNode(value);
        if (head == null) {
            head = newDNode;
            return head;
        }
        DNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newDNode;
        newDNode.prev = temp;
        return head;
    }

    public static DNode insertAtTail(int value, DNode head, DNode tail) {
        DNode newDNode = new DNode(value);
        if (head == null) {
            head = newDNode;
            tail = newDNode;
            return head;
        }
        tail.next = newDNode;
        newDNode.prev = tail;
        tail = newDNode;
        return head;
    }

    public static DNode insertAtPosition(int value, int position, DNode head) {
        if (position < 1)
            return head;
        if (position == 1)
            return insertAtHead(value, head);
        DNode temp = head;
        int p = 1;
        while (p < position - 1 && temp != null) {
            temp = temp.next;
            p++;
        }
        if (temp == null)
            return head;
        if (temp.next == null)
            return insertAtTail(value, head, temp);

        DNode newDNode = new DNode(value);
        newDNode.next = temp.next;
        temp.next.prev = newDNode;
        temp.next = newDNode;
        newDNode.prev = temp;
        return head;
    }

    public static DNode deleteValueFromLL(int value, DNode head) {
        DNode temp = head;
        DNode prevDNode = null;
        DNode nextDNode = null;

        if (head == null)
            return head;

        if (head.data == value) { // first position
            head = head.next;
            temp.next = null;
            if (head != null) // if LL length is not 1
                head.prev = null;
            return head;
        }

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }
        if (temp == null)
            return head;

        if(temp.next == null) // last position
        {
            temp.prev.next = null;
            temp.prev = null;
            return head;
        }

        prevDNode = temp.prev;
        nextDNode = temp.next;

        prevDNode.next = nextDNode;
        nextDNode.prev = prevDNode;

        temp.next = null;
        temp.prev = null;
        return head;
    }

    public static DNode deleteAtPosition(int position, DNode head) {
        DNode temp = head;
        DNode prevDNode = null;
        DNode nextDNode = null;

        if (head == null)
            return head;

        if (position == 1) { // first position
            head = head.next;
            temp.next = null;
            if (head != null) // if LL length is not 1
                head.prev = null;
            return head;
        }
        int p = 1;
        while (p < position && temp != null) {
            prevDNode = temp;
            temp = temp.next;
            p++;
        }
        if (temp == null) // out of range
            return head;
        if (temp.next == null) { // last position
            prevDNode.next = null;
            temp.prev = null;
            return head;
        }
        nextDNode = temp.next;
        prevDNode.next = nextDNode;
        nextDNode.prev = prevDNode;
        temp.next = null;
        temp.prev = null;
        return head;
    }

    public static void main(String[] args) {
        DNode head = new DNode(20);
        traverseListBothWay(head);
        head = insertAtHead(10, head);
        traverseListBothWay(head);
        head = insertAtTail(30, head);
        traverseListBothWay(head);
        head = insertAtPosition(50, 4, head);
        traverseListBothWay(head);
        head = insertAtPosition(40, 4, head);
        traverseListBothWay(head);
        int searchValue = 30;
        System.out.println(searchInAList(searchValue, head));
        head = deleteAtPosition(1, head);
        traverseListBothWay(head);
        head = deleteValueFromLL(50, head);
        traverseListBothWay(head);
    }
}
