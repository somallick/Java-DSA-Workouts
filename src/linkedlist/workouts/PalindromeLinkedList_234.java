package src.linkedlist.workouts;

// https://leetcode.com/problems/palindrome-linked-list
public class PalindromeLinkedList_234 {

    public static boolean isPalindrome(ListNode head) { // this is applicable when node value between [0,9] and no. of nodes is below INT_MAX
        int value = 0;
        int revValue = 0;
        int pow = 0;
        while (head != null) {
            value = value * 10 + head.val;
            revValue = (head.val * (int) Math.pow(10, pow)) + revValue;
            pow++;
            head = head.next;
        }
        if (value == revValue) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome_sol3(ListNode head) { // TC-O(n) SC-O(1)
        ListNode slowNode = head;
        ListNode prevNode = head;
        ListNode fastNode = head;
        if (head.next == null)
            return true;
        while (fastNode != null) { // reach the middle
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
                prevNode = slowNode;
                slowNode = slowNode.next;
            }
        }
        prevNode.next = null; // detach the first half
        ListNode firstLL = head;
        ListNode secondLL = slowNode;
        prevNode = null;
        while (secondLL != null) { // reverse the second half LL
            ListNode forward = secondLL.next;
            secondLL.next = prevNode;
            prevNode = secondLL;
            secondLL = forward;
        }
        secondLL = prevNode;
        while (firstLL != null) { // compare the first half vs second half(reverse)
            if (firstLL.val != secondLL.val)
                return false;
            firstLL = firstLL.next;
            secondLL = secondLL.next;
        }
        return true;
    }

    public static boolean isPalindrome_sol2(ListNode head) { // TC - O(n), SC - O(n)
        ListNode revHead = null;
        ListNode temp = head;
        while (temp != null) { // create another list in reverse order - O(n)
            ListNode newNode = new ListNode(temp.val);
            newNode.next = revHead;
            revHead = newNode;
            temp = temp.next;
        }
        temp = head;
        ListNode revTemp = revHead;
        while (temp != null) { // checking each element with reverse list - O(n)
            if (temp.val != revTemp.val)
                return false;
            temp = temp.next;
            revTemp = revTemp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1))));
        System.out.println(isPalindrome(head));
    }
}
