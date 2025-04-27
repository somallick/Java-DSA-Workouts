package src.linkedlist.assigment;

//https://leetcode.com/problems/odd-even-linked-list
public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        //if number of nodes > 2
        ListNode evenHead = head.next;

        //storing first node as prev odd node
        ListNode prevOdd = head;
        //storing second node as prev even node
        ListNode prevEven = head.next;

        // starting from third node
        ListNode curr = evenHead.next;
        int nodeNo = 3;

        while (curr != null) {
            if (nodeNo % 2 == 1) {
                prevOdd.next = curr;
                prevOdd = curr;
            } else {
                prevEven.next = curr;
                prevEven = curr;
            }
            curr = curr.next;
            nodeNo++;
        }

        if (nodeNo % 2 == 1)
            prevOdd.next = null;
        else
            prevEven.next = null;

        prevOdd.next = evenHead;
        return head;
    }
}
