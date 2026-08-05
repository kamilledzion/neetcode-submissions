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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> sum = new ArrayDeque<>();
        deque.addLast(root);
        sum.addLast(targetSum - root.val);

        while (!deque.isEmpty()) {
            var node = deque.pollLast();
            var curr = sum.pollLast();

            if (node.left == null && node.right == null && curr == 0) {
                return true;
            }
            
            if (node.right != null) {
                deque.addLast(node.right);
                sum.addLast(curr - node.right.val);
            } 
            if (node.left != null) {
                deque.addLast(node.left);
                sum.addLast(curr - node.left.val);
            } 
        }

        return false;
    }
}