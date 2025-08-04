package src.heap.workouts;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/check-completeness-of-a-binary-tree
public class CheckCompletenessOfBinaryTree_958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        boolean nullFound = false;

        while (!levelOrderQueue.isEmpty()) {
            TreeNode front = levelOrderQueue.poll();
            if (front == null)
                nullFound = true; // null node
            else {
                if (nullFound == true)// if null node is there before a non-null node
                    return false;
                levelOrderQueue.add(front.left);
                levelOrderQueue.add(front.right);
            }
        }
        return true;
    }
}
