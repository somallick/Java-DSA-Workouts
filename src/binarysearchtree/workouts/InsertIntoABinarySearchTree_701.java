package src.binarysearchtree.workouts;

//https://leetcode.com/problems/insert-into-a-binary-search-tree
public class InsertIntoABinarySearchTree_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            root = new TreeNode(val);
        else if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }
}
