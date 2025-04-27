package src.binarytree.workouts;

import java.util.Scanner;

public class TreePractise {
    public static TNode createTree() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a node value: ");
        // takes input from the keyboard
        int value = Integer.parseInt(input.nextLine());

        if (value == -1)
            return null;
        else {
            TNode root = new TNode(value);
            System.out.println("adding left child of " + value);
            root.left = createTree();
            System.out.println("adding right child of " + value);
            root.right = createTree();
            return root;
        }
    }

    public static void main(String[] args) {
        TNode root = createTree();
        System.out.println("Root TNode Value - " + root.value);
    }
}
class TNode {
    int value;
    TNode left;
    TNode right;

    TNode(int value) {
        this.value = value;
        left = right = null;
    }
}
