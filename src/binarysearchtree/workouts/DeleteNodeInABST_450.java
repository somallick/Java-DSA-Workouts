package src.binarysearchtree.workouts;

//https://leetcode.com/problems/delete-node-in-a-bst
public class DeleteNodeInABST_450 {
    public TreeNode deleteNode(TreeNode root, int key) { // TC - O(log n)
        if (root == null)
            return null;

        if (root.val == key) {

            // Case I - leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case II - have 1 left child only
            else if (root.left != null && root.right == null) {
                return root.left;
            }
            // Case III - have 1 right child only
            else if (root.left == null && root.right != null) {
                return root.right;
            }
            // Case IV - have both left and right child
            else if (root.left != null && root.right != null) {

                // get max value from the left subtree of the current node
                int max = getMaxValue(root.left);

                // replace the max value with current node value
                root.val = max;

                // delete the max value node from the left subtree of the current node i.e. the leaf node
                root.left = deleteNode(root.left, max);
            }
        } else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);

        return root;
    }

    public int getMaxValue(TreeNode root) {
        TreeNode prev = null;
        TreeNode temp = root;
        while (temp != null) {
            prev = temp;
            temp = temp.right;
        }
        return prev.val;
    }
}
