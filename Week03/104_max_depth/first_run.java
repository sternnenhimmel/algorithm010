/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
 首先，用最简单的递归
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(0,root);
    }
    int maxDepth(int d, TreeNode node){
        if(node == null) {
            return d;
        }
        int left = maxDepth(d+1, node.left);
        int right = maxDepth(d+1, node.right);
        return left>right?left:right;
    }
}