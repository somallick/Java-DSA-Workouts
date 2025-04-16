package src.binarytree.workouts;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePractise {

    public static Node createTreeFromArray(int[] arr, Integer index) {
        if (index >= arr.length || arr[index] == -1)
            return null;
        else {
            Node root = new Node(arr[index]);
            root.left = createTreeFromArray(arr, 2 * index + 1);
            root.right = createTreeFromArray(arr, 2 * index + 2);
            return root;
        }
    }

    public static Node createTreeFromQueue(Queue<Integer> queue) {
        if (queue.isEmpty() || queue.peek() == -1) {
            queue.poll();
            return null;
        } else {
            Node root = new Node(queue.poll());
            root.left = createTreeFromQueue(queue);
            root.right = createTreeFromQueue(queue);
            return root;
        }
    }

    public static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        //NLR - Order
        //N
        System.out.print(root.value + " ");
        //L
        preOrderTraversal(root.left);
        //R
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        //LNR - Order
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root) {
        if (root == null)
            return;
        //LRN - Order
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    public static void levelOrderTraversal(Node root) { // left to right
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            // pulling out from queue
            Node front = queue.poll();
            if (front == null) {
                //as it is null that means previous level all nodes are popped
                // and all child from next level has been put in the queue
                System.out.println();
                if (!queue.isEmpty())
                    queue.add(null);
            } else {
                //print its value
                System.out.print(front.value + " ");
                // put its child in the queue
                if (front.left != null)
                    queue.add(front.left);
                if (front.right != null)
                    queue.add(front.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 50, 40, -1, -1, -1, 30, 20, -1, -1, -1};
        Queue<Integer> queue = new LinkedList();
        queue.addAll(Arrays.asList(10, 50, 40, -1, -1, -1, 30, 20, -1, -1, -1));
        Node root = createTreeFromQueue(queue);
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        levelOrderTraversal(root);
    }
}
