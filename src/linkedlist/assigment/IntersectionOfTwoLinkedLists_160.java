package src.linkedlist.assigment;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-linked-lists
public class IntersectionOfTwoLinkedLists_160 {

    //TC O(m+n) SC(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
