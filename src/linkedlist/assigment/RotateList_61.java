package src.linkedlist.assigment;

//https://leetcode.com/problems/rotate-list
public class RotateList_61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode tail = null;
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            tail = temp;
            temp = temp.next;
        }
        while(k>length)
            k=k-length;
        if (k == length)
            return head;
        int t = 1;
        temp = head;
        while (t != (length - k)) {
            temp = temp.next;
            t++;
        }

        tail.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}
