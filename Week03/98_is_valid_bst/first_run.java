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
 首先是简单的递归调用，时间和空间复杂度都是o(n)
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean isValidBST(TreeNode node, long up, long low) {
        if(node.val>=up||node.val<=low) {
            return false;
        }
        if(node.left!=null){
            if(!isValidBST(node.left, node.val, low)){
                return false;
            }
        }
        if(node.right!=null) {
            if(!isValidBST(node.right, up, node.val)){
                return false;
            }
        }
        return true;
    }
}