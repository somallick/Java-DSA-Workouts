package src.binarytree.workouts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    //Using Queue (Iterative) – O(n) time and O(n) space
    public static ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> leftViewList = new ArrayList<>();
        Queue<Node> levelQueue = new LinkedList<>();
        if (root == null)
            return leftViewList;
        levelQueue.add(root);
        levelQueue.add(null);
        leftViewList.add(levelQueue.peek().value); // added the root in the left view
        while (!levelQueue.isEmpty()) {
            Node front = levelQueue.poll();
            if (front == null) {
                if (!levelQueue.isEmpty()) {
                    // adding the first element of each level from the queue
                    leftViewList.add(levelQueue.peek().value);
                    levelQueue.add(null);
                }
            } else {
                if (front.left != null)
                    levelQueue.add(front.left);
                if (front.right != null)
                    levelQueue.add(front.right);
            }
        }
        return leftViewList;
    }
    //Using Recursion – O(n) time and O(n) space
    public static void leftView(Node root, int level, ArrayList<Integer> leftViewList) {
        if(root==null)
            return;
        // when level match with size of the list that means
        //at that level will iterate the first number
        if(leftViewList.size() == level)
            leftViewList.add(root.value);
        leftView(root.left, level+1, leftViewList);
        leftView(root.right, level+1, leftViewList);
    }
    public static ArrayList<Integer> leftViewSol2(Node root) {
        ArrayList<Integer> leftViewList = new ArrayList<>();
        leftView(root,0,leftViewList);
        return leftViewList;
    }

}
