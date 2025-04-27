package src.binarysearchtree.workouts;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
public class ConvertSortedListToBinarySearchTree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        int length = getListLength(head);
        ListNode[] headList = new ListNode[]{head};
        return sortedListToBST(headList, length);
    }

    public TreeNode sortedListToBST(ListNode[] head, int length) {
        if (head[0] == null || length <= 0)
            return null;
        //LNR
        //L
        TreeNode leftST = sortedListToBST(head, length / 2);
        //N
        TreeNode root = new TreeNode(head[0].val);
        root.left = leftST;
        head[0] = head[0].next;
        //R
        TreeNode rightST = sortedListToBST(head, length - length / 2 - 1);
        root.right = rightST;
        return root;
    }

    public int getListLength(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
