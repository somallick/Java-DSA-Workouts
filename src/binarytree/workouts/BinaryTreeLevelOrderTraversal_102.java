package src.binarytree.workouts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal
public class BinaryTreeLevelOrderTraversal_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalTreeList = new ArrayList<>();
        if (root == null)
            return finalTreeList;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelValueList = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) {
                finalTreeList.add(levelValueList);
                levelValueList = new ArrayList<>();
                if (!queue.isEmpty()) // imp steps
                    queue.add(null);
            } else {
                levelValueList.add(front.val);
                if (!(front.left == null))
                    queue.add(front.left);
                if (!(front.right == null))
                    queue.add(front.right);
            }
        }
        return finalTreeList;
    }
}
