package src.binarytree.workouts;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
public class ConstructBinaryTreeFromPreorderInorder_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inOrderStartIndex = 0, inOrderEndIndex = inorder.length - 1, size = inorder.length;
        int[] preOrderIndex = new int[]{0};
        TreeNode root = buildTree(preorder, inorder, preOrderIndex, inOrderStartIndex, inOrderEndIndex, size);
        return root;
    }

    //sol 1
    public TreeNode buildTree(int[] preorder, int[] inorder, int[] preOrderIndex, int inOrderStartIndex, int inOrderEndIndex, int size) {
        if (preOrderIndex[0] >= size)
            return null;
        // as inorder array is shrinking in recursive call that why check
        if (inOrderStartIndex > inOrderEndIndex)
            return null;
        // step 1: get element from preorder and create the root node from it
        // process the first element of preOrder as root
        int rootElement = preorder[preOrderIndex[0]];
        preOrderIndex[0]++; // using an array for reference call(by reference) as same index should not process two times - very imp steps
        TreeNode root = new TreeNode(rootElement);
        //Step2: find this element inside inorder and call for left and right
        int elementIndexInsideInorder = getIndexInorder(inorder, rootElement);
        //inorder left part -> index inOrderStartIndex  to elementIndexInsideInorder - 1
        //inorder right part -> index elementIndexInsideInorder + 1 to inOrderEndIndex
        root.left = buildTree(preorder, inorder, preOrderIndex, inOrderStartIndex, elementIndexInsideInorder - 1, size);
        root.right = buildTree(preorder, inorder, preOrderIndex, elementIndexInsideInorder + 1, inOrderEndIndex, size);
        return root;
    }

    public int getIndexInorder(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++)
            if (inorder[i] == target)
                return i;
        return -1;
    }

    //sol 2 - converting the inorder array with map for search the index in each order
    // as search in map take O(1) time
    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> inOrderMap, int[] preOrderIndex, int inOrderStartIndex, int inOrderEndIndex, int size) {
        if (preOrderIndex[0] >= size)
            return null;
        if (inOrderStartIndex > inOrderEndIndex)
            return null;
        // step 1: get element from preorder and create the root node from it
        // process the first element of preOrder as root
        int rootElement = preorder[preOrderIndex[0]];
        preOrderIndex[0]++;
        TreeNode root = new TreeNode(rootElement);
        //Step2: find this element inside inorder and call for left and right
        int elementIndexInsideInorder = inOrderMap.get(rootElement);
        //inorder left part -> index inOrderStartIndex  to elementIndexInsideInorder - 1
        //inorder right part -> index elementIndexInsideInorder + 1 to inOrderEndIndex
        root.left = buildTree(preorder, inOrderMap, preOrderIndex, inOrderStartIndex, elementIndexInsideInorder - 1, size);
        root.right = buildTree(preorder, inOrderMap, preOrderIndex, elementIndexInsideInorder + 1, inOrderEndIndex, size);
        return root;
    }

    public Map<Integer, Integer> getIndexMapInorder(int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inOrderMap.put(inorder[i], i);
        return inOrderMap;
    }
}
