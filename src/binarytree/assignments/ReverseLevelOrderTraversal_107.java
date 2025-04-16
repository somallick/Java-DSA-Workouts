package src.binarytree.assignments;

import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii
public class ReverseLevelOrderTraversal_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if (root == null)
            return finalList;

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> levelList = new ArrayList<>();

        // Performing level order traversal
        // and storing the set of nodes values(as a list) of each level in a stack
        // so that retrieval can happen in reverse order for their level (LIFO)
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) {
                stack.push(levelList);
                levelList = new ArrayList<>();
                if (!queue.isEmpty())
                    queue.add(null);
            } else {
                levelList.add(front.val);
                if (!(front.left == null))
                    queue.add(front.left);
                if (!(front.right == null))
                    queue.add(front.right);
            }
        }
        // Retrieve the set of nodes value in reverse order of their level
        while (!stack.isEmpty()) {
            finalList.add(stack.pop());
        }
        return finalList;
    }
}
