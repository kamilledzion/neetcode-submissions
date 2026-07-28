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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode parent = null;
        TreeNode succ = null;
        while (curr != null && curr.val != key) {
            parent = curr;
            if (key < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null) {
            return root;
        }
        if (curr.left != null && curr.right != null) {
            parent = curr;
            succ = curr.right;
            while(succ.left != null) {
                parent = succ;
                succ = succ.left;
            }
            curr.val = succ.val;
            curr = succ;
        } 
        succ = curr.left != null ? curr.left : curr.right;
        if (parent == null) {
            return succ;
        }
        if (parent.left == curr) {
            parent.left = succ;
        } else {
            parent.right = succ;
        }

        return root;
    }

    TreeNode findLowestLeft(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}