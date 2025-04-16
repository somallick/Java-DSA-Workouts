package src.binarytree.workouts;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
public class TreeBoundaryTraversal {
    public ArrayList<Integer> boundaryTraversal(Node node) {
        Node root = node;
        ArrayList<Integer> finalList = new ArrayList<>();

        // Case I - Store the root node in list
        finalList.add(root.value);
        // Case II - Store left subtree - non leaf nodes - left boundary
        boundaryTraversalLeftST(root.left, finalList);
        // Case III - Store left subtree - leaf nodes - leaf boundary
        boundaryTraversalLeafNodes(root.left, finalList);
        // Case IV - Store right subtree - leaf nodes - leaf boundary
        boundaryTraversalLeafNodes(root.right, finalList);
        // Case V - Store right subtree - non leaf nodes in reverse order - right boundary
        boundaryTraversalRightST(root.right, finalList);
        return finalList;
    }

    public void boundaryTraversalLeftST(Node node, ArrayList<Integer> list) {
        if (node == null)
            return;
        //ignore leaf node
        if (node.left == null && node.right == null)
            return;
        //store
        list.add(node.value);
        // traverse left node and if not present then right node
        if (node.left != null)
            boundaryTraversalLeftST(node.left, list);
        else
            boundaryTraversalLeftST(node.right, list);
    }

    public void boundaryTraversalLeafNodes(Node node, ArrayList<Integer> list) {
        // code here
        if (node == null)
            return;
        //store leaf node
        if (node.left == null && node.right == null)
            list.add(node.value);
        boundaryTraversalLeafNodes(node.left, list);
        boundaryTraversalLeafNodes(node.right, list);
    }

    public void boundaryTraversalRightST(Node node, ArrayList<Integer> list) {
        if (node == null)
            return;
        //ignore leaf node
        if (node.left == null && node.right == null)
            return;
        // traverse right node and if not present then left node
        if (node.right != null)
            boundaryTraversalRightST(node.right, list);
        else
            boundaryTraversalRightST(node.left, list);
        //As node value need to store in reverse traverse order - imp steps
        list.add(node.value);
    }
}
