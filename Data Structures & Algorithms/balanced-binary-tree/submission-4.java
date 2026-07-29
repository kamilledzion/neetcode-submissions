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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Map<TreeNode, Integer> map = new HashMap();
        Deque<TreeNode> deque = new ArrayDeque();
        deque.addLast(root);
        
        while (!deque.isEmpty()) {
            var curr = deque.peekLast();
            if (curr.left != null && !map.containsKey(curr.left)) {
                deque.addLast(curr.left);
            } else if (curr.right != null && !map.containsKey(curr.right)) {
                deque.addLast(curr.right);
            } else {
                var left = map.getOrDefault(curr.left, 0);
                var right = map.getOrDefault(curr.right, 0);
                if (Math.abs(left - right) > 1) {
                    return false;
                } 

                map.put(curr, Math.max(left, right) + 1);
                deque.pollLast();
            }
        }
        return true;
    }
}
