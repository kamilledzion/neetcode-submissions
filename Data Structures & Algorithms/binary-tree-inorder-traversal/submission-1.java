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
    public List<Integer> inorderTraversal(TreeNode root) {
        List result = new ArrayList<Integer>();

        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        while(!deque.isEmpty() || root != null) {
            addToStack(deque, root);
            
            root = deque.pollLast();
            result.add(root.val);

            root = root.right;
        }

        return result;
    }

    void addToStack(Deque deque, TreeNode root) {
        while (root != null) {
            deque.addLast(root);
            root = root.left;
        }
    }
}