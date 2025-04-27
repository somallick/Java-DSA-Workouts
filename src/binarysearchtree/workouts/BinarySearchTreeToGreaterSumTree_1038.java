package src.binarysearchtree.workouts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinarySearchTreeToGreaterSumTree_1038 {
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        Map<Integer, Integer> gstTracker = new HashMap<>();
        // store the node value in order way - sorted manner
        inorderTraversal(root, inOrderList);
        int sum = 0;
        // for each node value, storing sum of own value and all the values that are greater than itself
        for (int i = inOrderList.size() - 1; i >= 0; i--) {
            sum += inOrderList.get(i);
            gstTracker.put(inOrderList.get(i), sum);
        }
        // replacing each value of node with greater sum value
        return getGreaterSumTree(root, gstTracker);
    }

    public void inorderTraversal(TreeNode root, List<Integer> inOrderList) {
        if (root == null)
            return;
        //LNR
        inorderTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        inorderTraversal(root.right, inOrderList);
    }

    public TreeNode getGreaterSumTree(TreeNode root, Map<Integer, Integer> gstTracker) {
        if (root == null)
            return null;
        root.val = gstTracker.get(root.val);
        root.left = getGreaterSumTree(root.left, gstTracker);
        root.right = getGreaterSumTree(root.right, gstTracker);
        return root;
    }
}
