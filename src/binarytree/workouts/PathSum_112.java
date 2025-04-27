package src.binarytree.workouts;

//https://leetcode.com/problems/path-sum
public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        // when any leaf node is reach check the remaining value of targetSum is same
        // as that of value of the leaf node (Base Case)
        if (root.left == null && root.right == null && targetSum - root.val == 0)
            return true;

        // travel each node of subtree and reduce/subtract the target sum by node value (non leaf)
        boolean statusLT = hasPathSum(root.left, targetSum - root.val);
        boolean statusRT = hasPathSum(root.right, targetSum - root.val);
        return (statusLT || statusRT);

    }
}
