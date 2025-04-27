package src.binarysearchtree.workouts;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst
public class KthSmallestElementInBst_230 {

    // sol1 - TC(n) SC(n)
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> inOrderList = new ArrayList<>();
        //As inorder traversal list is sorted
        inOrderTraversal(root, inOrderList);
        // K-1 element as kth is element as list is 0 indexed
        return inOrderList.get(k - 1);

    }

    public void inOrderTraversal(TreeNode root, List<Integer> inOrderList) {
        if (root == null)
            return;
        inOrderTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrderTraversal(root.right, inOrderList);
    }

    //sol2 - TC(n) SC(n)
    public int kthSmallest_sol2(TreeNode root, int k) {
        int[] index_ans = new int[]{k, 0};
        kthSmallest(root, index_ans);
        return index_ans[1];
    }

    public void kthSmallest(TreeNode root, int[] index_ans) {
        if (root == null)
            return;
        //Traversing in inorder traversal LNR
        kthSmallest(root.left, index_ans);
        // when N is visited each time reducing the index[0] till its zero
        // and when its zero then storing the value at index 1
        index_ans[0]--;
        if (index_ans[0] == 0)
            index_ans[1] = root.val;
        kthSmallest(root.right, index_ans);
    }
}
