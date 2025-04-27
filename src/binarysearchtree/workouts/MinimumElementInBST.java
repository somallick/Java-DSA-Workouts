package src.binarysearchtree.workouts;

//https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
public class MinimumElementInBST {

    //O(n) Time and O(1) Space
    int minValue(Node root) {
        // code here
        Node prev = null;
        Node temp = root;
        while(temp != null){
            prev = temp;
            temp = temp.left;
        }
        return prev.data;
    }

    //O(n) Time and O(n) Space
    int minValue_sol2(Node root) {
        // code here
        if(root==null)
            return root.data;
        return minValue_sol2(root.left);
    }
}
