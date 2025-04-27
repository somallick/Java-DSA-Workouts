package src.binarysearchtree.workouts;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
public class LowestCommonAncestorOfBinarySearchTree_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val)
            return lowestCommonAncestorSolve(root, p, q);
        else
            return lowestCommonAncestorSolve(root, q, p);
    }

    // assuming p value is smaller than q
    public TreeNode lowestCommonAncestorSolve(TreeNode root, TreeNode p, TreeNode q) { // TC - O(log n)
        //case 1
        if (root == null)
            return null;
        //case 2.1
        if (root.val == p.val)
            return p;
        //case 2.2
        if (root.val == q.val)
            return q;
        // case 3 current root node lies b/w p and q
        if (p.val < root.val && root.val < q.val)
            return root;
        // as the above condition doesn't satisfy
        // then Case 4 and 5 both p and q lies either in the left subtree or right subtrees of current root
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestorSolve(root.left, p, q);
        else
            return lowestCommonAncestorSolve(root.right, p, q);
    }
}
