package src.binarysearchtree.assignments;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/validate-binary-search-tree
public class ValidateBinarySearchTree_98 {

    public boolean isValidBST(TreeNode root) {
        int[] prev = new int[]{Integer.MIN_VALUE, 0};
        return isValidBSTCheck(root, prev);
    }

    //Using Inorder Traversal – O(n) Time and O(h) Space
    public boolean isValidBSTCheck(TreeNode root, int[] prev) {
        if (root == null)
            return true;
        //LNR - inorder - it should be sorted else not bst
        boolean isValidLeftST = isValidBSTCheck(root.left, prev);
        if (!isValidLeftST)
            return false;

        if (prev[0] >= root.val)
            return false;

        prev[0] = root.val;

// this code is applicable for Integer MAX & MIN Value as node value in leetcode testcase
//        if(prev[1] == 0 && prev[0] == root.val){
//            prev[0] = root.val;
//            prev[1] = 1;
//        }
//        else if (prev[0] >= root.val)
//            return false;
//        else {
//            prev[0] = root.val;
//            prev[1] = 1;
//        }

        return isValidBSTCheck(root.right, prev);
    }


    //sol 1
    public boolean isValidBST_sol1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
}
