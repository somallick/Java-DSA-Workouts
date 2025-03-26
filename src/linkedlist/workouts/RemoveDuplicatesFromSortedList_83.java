package src.linkedlist.workouts;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list
public class RemoveDuplicatesFromSortedList_83 {
    public static ListNode deleteDuplicates_sol1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode temp = head.next;
        while (temp != null) {
            if (temp.val == prev.val) {
                prev.next = temp.next;
                temp.next = null;
            } else {
                prev = prev.next;
                temp = temp.next;
            }
            temp = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10,
                new ListNode(10,
                        new ListNode(10,
                                new ListNode(20,
                                        new ListNode(30,
                                                new ListNode(30))))));
        LLUtility.printLL(head);
        head = deleteDuplicates_sol1(head);
        LLUtility.printLL(head);

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode temp = head.next;
        while (temp != null) {
            if (temp.val != prev.val) {
                prev.next = temp;
                prev = temp;
            }
            temp = temp.next;
        }
        prev.next = null; // if prev.next is not null means rest are duplicates
        return head;
    }
}
