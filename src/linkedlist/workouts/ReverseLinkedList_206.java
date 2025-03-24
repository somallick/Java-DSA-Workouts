package src.linkedlist.workouts;

//https://leetcode.com/problems/reverse-linked-list
public class ReverseLinkedList_206 {
    public static ListNode reverseListRE(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        return reverseList(prev, head);
    }
    public static ListNode reverseList(ListNode prev, ListNode curr) { // Recursive
        if(curr == null)
            return prev;
        ListNode forward = curr.next;
        curr.next = prev;
        prev = curr;
        curr=forward;
        return reverseList(prev,curr);
    }

    public static ListNode reverseList(ListNode head) { // loop
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10, new ListNode(20, new ListNode(30,new ListNode(40))));
        LLUtility.printLL(head);
        head = reverseList(head);
        LLUtility.printLL(head);
    }
}
