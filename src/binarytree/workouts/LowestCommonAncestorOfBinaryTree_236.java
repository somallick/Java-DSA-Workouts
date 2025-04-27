package src.binarytree.workouts;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
public class LowestCommonAncestorOfBinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //case 1
        if (root == null)
            return null;

        //case 2.1
        if (root.val == p.val)
            return p;

        //case 2.2
        if (root.val == q.val)
            return q;

        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        // case 3
        if (leftTree != null && rightTree != null)
            return root;

        // case 2.3
        return (leftTree != null ? leftTree : rightTree);

    }
}
