package src.binarytree.workouts;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
public class ConstructBinaryTreeFromPostorderInorder_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inOrderStartIndex = 0, inOrderEndIndex = inorder.length - 1, size = inorder.length;
        int[] postOrderIndex = new int[]{size-1};
        Map<Integer, Integer> inOrderMap = getIndexMapInorder(inorder);
        TreeNode root = buildTree(postorder, inOrderMap, postOrderIndex, inOrderStartIndex, inOrderEndIndex, size);
        return root;
    }
    public TreeNode buildTree(int[] postorder, Map<Integer, Integer> inOrderMap, int[] postOrderIndex, int inOrderStartIndex, int inOrderEndIndex, int size) {
        if (postOrderIndex[0] < 0)
            return null;
        if (inOrderStartIndex > inOrderEndIndex)
            return null;
        // step 1: get element from postorder and create the root node from it
        // process the first element of postOrder as root
        int rootElement = postorder[postOrderIndex[0]];
        postOrderIndex[0]--;
        TreeNode root = new TreeNode(rootElement);
        //Step2: find this element inside inorder and call for left and right
        int elementIndexInsideInorder = inOrderMap.get(rootElement);
        //inorder right part -> index elementIndexInsideInorder + 1 to inOrderEndIndex
        //inorder left part -> index inOrderStartIndex  to elementIndexInsideInorder - 1
        root.right = buildTree(postorder, inOrderMap, postOrderIndex, elementIndexInsideInorder + 1, inOrderEndIndex, size);
        root.left = buildTree(postorder, inOrderMap, postOrderIndex, inOrderStartIndex, elementIndexInsideInorder - 1, size);
        return root;
    }
    public Map<Integer, Integer> getIndexMapInorder(int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inOrderMap.put(inorder[i], i);
        return inOrderMap;
    }
}
