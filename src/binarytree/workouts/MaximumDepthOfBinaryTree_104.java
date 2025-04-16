package src.binarytree.workouts;

//https://leetcode.com/problems/maximum-depth-of-binary-tree
public class MaximumDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int count = 1;
        int countLeft = maxDepth(root.left);
        int countRight = maxDepth(root.right);
        count = count + Math.max(countLeft,countRight);
        return count;
    }
}
