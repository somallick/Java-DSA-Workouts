package src.binarytree.workouts;

//https://leetcode.com/problems/balanced-binary-tree
public class BalancedBinaryTree_110 {

    //Fast Sol - Bottom Up Recursive – O(n) Time and O(h) Space
    public boolean isBalanced(TreeNode root) {
        int[] store = new int[]{0};
        isBalanced(root, store);
        if (store[0] <= 1)
            return true;
        return false;
    }

    public int isBalanced(TreeNode root, int[] store) {
        if (root == null)
            return 0;
        int heightRoot = 1;
        int heightLT = isBalanced(root.left, store);
        int heightRT = isBalanced(root.right, store);
        store[0] = Math.max(store[0], Math.abs(heightLT - heightRT));
        heightRoot += Math.max(heightLT, heightRT);
        return heightRoot;

    }

    // Slow  Sol - Top down recursion approach - TC - O(n^2)
    public boolean isBalanced_sol1(TreeNode root) {
        if (root == null)
            return true;

        int heightLT = getHeight(root.left);
        int rightRT = getHeight(root.right);
        boolean status = (Math.abs(heightLT - rightRT) <= 1);

        boolean leftAllNodeAns = isBalanced_sol1(root.left);
        boolean rightAllNodeAns = isBalanced_sol1(root.right);
        if (status && leftAllNodeAns && rightAllNodeAns)
            return true;
        else
            return false;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int count = 1;
        int countLeft = getHeight(root.left);
        int countRight = getHeight(root.right);
        count = count + Math.max(countLeft, countRight);
        return count;
    }
}
