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
        Set<TreeNode> visited = new HashSet();
        Deque<TreeNode> deque = new ArrayDeque();
        deque.addLast(root);
        
        while (!deque.isEmpty()) {
            var curr = deque.peekLast();

            if (curr.left != null && !visited.contains(curr.left)) {
                deque.addLast(curr.left);
            } else {
                var node = deque.pollLast();
                visited.add(node);
                k--;
                if (k == 0) {
                    return node.val;
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return root.val;
    }
}
