package src.linkedlist.workouts;

//https://leetcode.com/problems/middle-of-the-linked-list
public class MiddleOfTheLinkedList_876 {

    // single traversal or tortoise approach
    public ListNode middleNode(ListNode head) {
        ListNode fastTemp = head; // 2 steps
        ListNode slowTemp = head; // 1 step
        while (fastTemp != null) {
            fastTemp = fastTemp.next;
            if (fastTemp != null) {
                fastTemp = fastTemp.next;
                slowTemp = slowTemp.next;
            }
        }
        return slowTemp;
    }

    //Two times traversal
    public static ListNode middleNode_sol1(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int mid = (length / 2) + 1;
        int p = 1;
        while (p != mid) {
            temp = temp.next;
            p++;
        }
        return temp;
    }
}
