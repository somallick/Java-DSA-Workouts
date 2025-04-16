package src.binarytree.workouts;

//https://leetcode.com/problems/diameter-of-binary-tree
public class DiameterOfBinaryTree_543 {

    //Fast Sol - Bottom Up Recursive – O(n) Time and O(h) Space
    public int diameterOfBinaryTree(TreeNode root, int[] store) {
        if (root == null)
            return 0;
        int heightRoot = 1;
        // find the height of left and right subtree
        // (it will also find of diameter for left
        // and right subtree).
        int heightLT = diameterOfBinaryTree(root.left, store);
        int heightRT = diameterOfBinaryTree(root.right, store);
        // Check if diameter of root is greater than store.
        store[0] = Math.max(store[0], (heightLT + heightRT));
        // return the height of current subtree.
        heightRoot += Math.max(heightLT, heightRT);
        return heightRoot;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] store = new int[]{0};
        diameterOfBinaryTree(root, store);
        return store[0];
    }

    // Normal Sol - Top down recursion approach - TC - O(n^2)
    public int diameterOfBinaryTreeSol1(TreeNode root) {
        if (root == null)
            return 0;

        // Return max of the following three:
        // 1) Diameter of left subtree
        // 2) Diameter of right subtree
        // 3) Height of left subtree + height of right subtree
        int option1 = diameterOfBinaryTreeSol1(root.left); // answer in left subtree
        int option2 = diameterOfBinaryTreeSol1(root.right); // answer in right subtree
        int option3 = heightOfBinaryTree(root.left) + heightOfBinaryTree(root.right); // answer in total sob subtree height
        int maxDiameter = Math.max(option1, Math.max(option2, option3));
        return maxDiameter;
    }

    public int heightOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int count = 1;
        int countLeft = heightOfBinaryTree(root.left);
        int countRight = heightOfBinaryTree(root.right);
        count = count + Math.max(countLeft, countRight);
        return count;
    }
}
