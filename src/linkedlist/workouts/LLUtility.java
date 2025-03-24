package src.linkedlist.workouts;

import src.linkedlist.workouts.ListNode;
import src.linkedlist.workouts.model.Node;

public class LLUtility {
    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
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
//    public  static ListNode createLL(int... temp) {
//        ListNode head;
//        for()
//
//    }
}
