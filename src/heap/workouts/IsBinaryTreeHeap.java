package src.heap.workouts;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1
public class IsBinaryTreeHeap {
    boolean isHeap(Node tree) {
        // code here
        return isCompleteTree(tree) && isMaxHeapSatisfy(tree);
    }

    public boolean isMaxHeapSatisfy(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        // case 1 - check whether root is greater than left node and right node - max heap property
        boolean isLeftNode = true;
        if (root.left != null && root.data < root.left.data)
            isLeftNode = false;
        boolean isRightNode = true;
        if (root.right != null && root.data < root.right.data)
            isRightNode = false;
        boolean isRootMaxHeap = isLeftNode && isRightNode;

        // case 2,3 - check whether left ST and right ST of root is max heap or not - max heap property
        boolean isLeftTreeMaxHeap = isMaxHeapSatisfy(root.left);
        boolean isRightTreeMaxHeap = isMaxHeapSatisfy(root.right);

        // check case 1,2,3 all are true or not then max heap tree confirmed
        if (isRootMaxHeap && isLeftTreeMaxHeap && isRightTreeMaxHeap)
            return true;
        else
            return false;
    }

    public boolean isCompleteTree(Node root) {
        Queue<Node> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        boolean nullFound = false;

        while (!levelOrderQueue.isEmpty()) {
            Node front = levelOrderQueue.poll();
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
