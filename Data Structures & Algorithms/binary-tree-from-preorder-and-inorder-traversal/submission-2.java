/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    Map<Integer, Integer> inorderToIndex = new HashMap<>();
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
        for (int i = 0; i < inorder.length; i++) {
            inorderToIndex.put(inorder[i], i);
        }

        return buildTree(preorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index++]);
        var nodeIndex = inorderToIndex.get(node.val);

        node.left = buildTree(preorder, left, nodeIndex - 1);
        node.right = buildTree(preorder, nodeIndex + 1, right);

        return node;
    }
}
