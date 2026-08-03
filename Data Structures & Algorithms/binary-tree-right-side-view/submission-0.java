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
    Set<Integer> visitedLevel = new HashSet<>();
    List<Integer> result = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (!visitedLevel.contains(level)) {
            visitedLevel.add(level);
            result.add(root.val);
        }
        
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
