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
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[]{0, k};
        dfs(root, result);
       return result[0];
    }

    void dfs(TreeNode root, int[] result) {
         if (root == null) {
            return;
        }
        dfs(root.left, result);
        result[1]--;
        if (result[1] == 0) {
            result[0] = root.val;
        }
        dfs(root.right, result);
    }
}
