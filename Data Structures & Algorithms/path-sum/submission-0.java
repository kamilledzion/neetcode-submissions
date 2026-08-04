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

    int currentSum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        currentSum += root.val;

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                return true;
            } else {
                currentSum -= root.val;
                return false;
            }
        }

        if (hasPathSum(root.left, targetSum)) {
            return true;
        }
        if (hasPathSum(root.right, targetSum)) {
            return true;
        }
        currentSum -= root.val;

        return false;
    }
}