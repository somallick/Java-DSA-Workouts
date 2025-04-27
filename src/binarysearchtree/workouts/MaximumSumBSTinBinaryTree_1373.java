package src.binarysearchtree.workouts;

//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree
public class MaximumSumBSTinBinaryTree_1373 {
    public int maxSumBST(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        maxSumBST(root, maxSum);
        return (maxSum[0] > 0) ? maxSum[0] : 0;
    }

    public Info maxSumBST(TreeNode root, int[] maxSum) {
        if (root == null) {
            Info info = new Info();
            info.max = Integer.MIN_VALUE;
            info.min = Integer.MAX_VALUE;
            info.sum = 0;
            info.isBST = true;
            return info;
        }
        //LRN
        //L - get the left ST with min value node and max value node
        // and total sum of all nodes and is it BST or not
        Info leftST = maxSumBST(root.left, maxSum);
        //R - get the right ST with min value node and max value node
        // and total sum of all nodes and is it BST or not
        Info rightST = maxSumBST(root.right, maxSum);
        //N - fill the root node info max, min value and total sum of value with ST
        Info rootInfo = new Info();
        rootInfo.max = Math.max(root.val, Math.max(leftST.max, rightST.max));
        rootInfo.min = Math.min(root.val, Math.min(leftST.min, rightST.min));
        rootInfo.sum = root.val + leftST.sum + rightST.sum;
        // root is BST - when its value is more than min value in left ST
        // and less than max value in right ST and both ST are BST
        rootInfo.isBST = root.val > leftST.max && root.val < rightST.min && leftST.isBST && rightST.isBST;
        // BST node sum value is only captured as max sum
        if (rootInfo.isBST)
            maxSum[0] = Math.max(maxSum[0], rootInfo.sum);
        return rootInfo;
    }

    class Info {
        int min;
        int max;
        int sum;
        boolean isBST;
    }
}
