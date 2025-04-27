package src.binarytree.workouts;

import java.util.*;

//https://leetcode.com/problems/path-sum-ii
public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, targetSum, path, allPath);
        return allPath;
    }

    public void pathSum(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> allPath) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0)
                allPath.add(new ArrayList<>(path));
            // backtracking - popping the node data from list once visited
            path.remove(path.size() - 1);
            return;
        }
        pathSum(root.left, targetSum - root.val, path, allPath);
        pathSum(root.right, targetSum - root.val, path, allPath);
        // backtracking - popping the node data from list once visited
        path.remove(path.size() - 1);
    }
}
