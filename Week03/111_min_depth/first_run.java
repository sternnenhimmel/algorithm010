/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 首先还是用最简单的递归来解，求最小，写起来还是坑爹的，边界条件比较难以理清楚
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left==null) {
            return minDepth(root.right)+1;
        }
        if(root.right == null) {
            return minDepth(root.left)+1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left,right)+1;
    }
}