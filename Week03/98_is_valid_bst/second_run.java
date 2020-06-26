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
 由于是二叉树的题目，所以一定可以使用迭代来实现，看了题解以后，尝试用中序遍历单调递增的方法实现，同时再连续以下用栈对递归的替代
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack<TreeNode>stack = new Stack<>();
        long max = Long.MIN_VALUE;
        TreeNode curr = root;
        while(!stack.isEmpty() || curr!=null){
            while(curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val<=max){
                return false;
            }
            max = curr.val;
            curr=curr.right;
        }
        return true;
    }
}