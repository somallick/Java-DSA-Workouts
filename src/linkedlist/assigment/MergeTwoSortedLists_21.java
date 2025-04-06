package src.linkedlist.assigment;

public class MergeTwoSortedLists_21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) { // TC O(m+n) SC O(1)
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode finalTail = null;
        ListNode finalHead = null;
        ListNode toMove = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                toMove = list1;
                list1 = list1.next;
            } else {
                toMove = list2;
                list2 = list2.next;
            }
            toMove.next = null;
            if (finalHead == null) {
                finalHead = toMove;
                finalTail = toMove;
            } else {
                finalTail.next = toMove;
                finalTail = finalTail.next;
            }
        }
        if (list1 != null)
            finalTail.next = list1;
        if (list2 != null)
            finalTail.next = list2;
        return finalHead;
    }
}
