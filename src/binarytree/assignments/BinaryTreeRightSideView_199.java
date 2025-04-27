package src.binarytree.assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view
public class BinaryTreeRightSideView_199 {
    //Using Queue (Iterative) – O(n) time and O(n) space
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new ArrayList<>();
        if (root == null)
            return rightViewList;
        Queue<TreeNode> queue = new LinkedList<>();
        int rightViewNodeValue = 0;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) {
                // storing last node value in each level
                rightViewList.add(rightViewNodeValue);
                if (!queue.isEmpty()) // imp steps
                    queue.add(null);
            } else {
                // value of each non-null node after removing from queue
                rightViewNodeValue = front.val;
                if (!(front.left == null))
                    queue.add(front.left);
                if (!(front.right == null))
                    queue.add(front.right);
            }
        }
        return rightViewList;
    }

    //Using Recursion – O(n) time and O(n) space
    public static void rightSideView(TreeNode root, int level, ArrayList<Integer> rightViewList) {
        if(root==null)
            return;
        // when level match with size of the list that means
        //at that level will iterate the first number from the right side
        if(rightViewList.size() == level)
            rightViewList.add(root.val);
        rightSideView(root.right, level+1, rightViewList);// first right traversal as right view is required
        rightSideView(root.left, level+1, rightViewList);
    }
    public static ArrayList<Integer> rightSideViewSol2(TreeNode root) {
        ArrayList<Integer> rightViewList = new ArrayList<>();
        rightSideView(root,0,rightViewList);
        return rightViewList;
    }
}
