package src.binarysearchtree.workouts;

public class BSTPractise {
    public static Node createTree(int[] arr) {
        Node root = null;
        for (int val : arr) {
            root = insertInBST(root, val);
        }
        return root;
    }

    // TC - O(n)
    public static Node insertInBST(Node root, int val) {
        if (root == null)
            root = new Node(val);
        else if (val <= root.data)
            root.left = insertInBST(root.left, val);
        else
            root.right = insertInBST(root.right, val);
        return root;
    }

    public static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        //NLR
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        //LNR
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }


    public static void postOrderTraversal(Node root) {
        if (root == null)
            return;
        //LRN
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, 50, 200, 70, 20, 250, 150};
        Node root = createTree(arr);
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
    }
}
