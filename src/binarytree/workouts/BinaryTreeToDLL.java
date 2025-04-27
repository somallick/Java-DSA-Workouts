package src.binarytree.workouts;

//https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1
public class BinaryTreeToDLL {
    Node bToDLL(Node root) {
        Node[] head = new Node[]{null};
        constructDLL(root, head);
        return head[0];
    }

    //headTail store head node object and tail node object at index 0 and 1 respectively
    void constructDLL(Node root, Node[] headTail) {
        if (root == null)
            return;
        //LNR
        //L
        constructDLL(root.left, headTail);
        //N
        if (headTail[0] == null && headTail[1] == null) {
            headTail[0] = root;
            headTail[1] = root;
        } else {
            headTail[1].right = root;
            root.left = headTail[1];
            headTail[1] = root;
        }
        //R
        constructDLL(root.right, headTail);
    }

    // Sol 2 - Using RNL approach
    void constructDLL_sol1(Node root, Node[] head) {
        if (root == null)
            return;

        //RNL
        //R
        constructDLL(root.right, head);
        //N
        root.right = head[0];
        if (head[0] != null)
            head[0].left = root;
        head[0] = root;
        //L
        constructDLL(root.left, head);

    }
}
