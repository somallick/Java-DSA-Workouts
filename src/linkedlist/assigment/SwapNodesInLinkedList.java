package src.linkedlist.assigment;

//https://leetcode.com/problems/swapping-nodes-in-a-linked-list
public class SwapNodesInLinkedList {

    // sol 2 - little fast sol - tricky approach
    public ListNode swapNodes(ListNode head, int k){

        if(head == null || head.next == null) return head;

        ListNode frontCurr = head;
        for(int i=1; i<k; i++) {
            frontCurr = frontCurr.next;
        }

        ListNode endCurr = head;
        ListNode temp = frontCurr;
        while(temp.next!=null) {
            endCurr = endCurr.next;
            temp = temp.next;
        }

        int value =  frontCurr.val;
        frontCurr.val = endCurr.val;
        endCurr.val = value;
        return head;
    }

    // sol1 - easy and general sol
    public ListNode swapNodes_sol1(ListNode head, int k) {

        ListNode startK = null;
        ListNode endK = null;

        ListNode temp = head;
        int length = 0;

        while(temp != null) {
            length++;
            if(length == k){
                startK = temp;
            }
            temp = temp.next;
        }

        int kthIndexFromEnd = length - k + 1;
        temp = head;
        int count = 0;

        while(temp != null) {
            count++;
            if(count == kthIndexFromEnd){
                endK = temp;
                break;
            }
            temp = temp.next;
        }

        int curr =  startK.val;
        startK.val = endK.val;
        endK.val = curr;

        return head;
    }
}
