package src.linkedlist.assigment;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-linked-lists
public class IntersectionOfTwoLinkedLists_160 {

    //TC O(m+n) SC O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        //loop until we found the first common intersection node or both null if no interaction
        while (ptrA != ptrB) {
            ptrA = (ptrA == null) ? headB : ptrA.next; // once we're done with A, move to B
            ptrB = (ptrB == null) ? headA : ptrB.next; // once we're done with A, move to B
        }
        return ptrA;
    }

    //TC O(m+n) SC O(n)
    public ListNode getIntersectionNode_sol2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }
        while (tempB != null) {
            if (set.contains(tempB))
                return tempB;
            tempB = tempB.next;
        }
        return null;
    }
}
