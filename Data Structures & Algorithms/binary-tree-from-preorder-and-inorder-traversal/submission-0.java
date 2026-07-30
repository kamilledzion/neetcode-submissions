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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        var index = findIndex(inorder, root.val);

        var leftInorder = Arrays.copyOfRange(inorder, 0, index);
        var leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1);
        root.left = buildTree(leftPreorder, leftInorder);

        var rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        var rightpreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);
        root.right = buildTree(rightpreorder, rightInorder);

        return root;
    }

    int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
