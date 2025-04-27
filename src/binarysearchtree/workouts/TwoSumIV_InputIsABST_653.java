package src.binarysearchtree.workouts;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst
public class TwoSumIV_InputIsABST_653 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inOrderList = new ArrayList<>();
        // store the node value in inorder way - sorted manner
        inorderTraversal(root, inOrderList);

        // use two pointer algo for sum of two variable in sorted list
        int start = 0;
        int end = inOrderList.size() - 1;
        while (start < end) {
            int sum = inOrderList.get(start) + inOrderList.get(end);
            if (sum == k)
                return true;
            else if (sum < k)
                start++;
            else
                end--;
        }
        return false;
    }

    public void inorderTraversal(TreeNode root, List<Integer> inOrderList) {
        if (root == null)
            return;
        //LNR
        inorderTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        inorderTraversal(root.right, inOrderList);
    }
}
