package src.binarysearchtree.workouts;

public class SearchInABinarySearchTree_700 {

    //Recursive - TC O(h), SC O(h) where h is the height of the BST.
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else if (val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    //Iterative - TC O(h), SC O(1) where h is the height of the BST.
    public TreeNode searchBST_Sol2(TreeNode root, int val) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val == val)
                return temp;
            if (val < temp.val)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return null;
    }
}
