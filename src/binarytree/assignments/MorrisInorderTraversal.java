package src.binarytree.assignments;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/inorder-traversal/1
public class MorrisInorderTraversal {
    //TC - O(n) SC-O(1)
    public ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> inOrderList = new ArrayList<>();
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                inOrderList.add(curr.data);
                curr = curr.right;
            } else {
                // calculate the inorder predecessor for curr node
                Node predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                // Make curr the right child of its in order predecessor - create thread/link
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null; // Revert the changes made for predecessor right child - delete thread/link
                    inOrderList.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return inOrderList;
    }
}
