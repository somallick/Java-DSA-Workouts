package src.binarytree.assignments;

import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzagLevelOrder(root, new int[]{1});
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root, int[] level) {
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
                if (level[0] % 2 == 0) // at even level, reverse the list
                    Collections.reverse(levelValueList);
                finalTreeList.add(levelValueList);
                levelValueList = new ArrayList<>();
                level[0] += 1;
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
