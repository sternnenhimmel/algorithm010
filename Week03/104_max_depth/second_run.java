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
 然后再练习一下用栈迭代的方法
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Stack<Pair<Integer,TreeNode>>stack = new Stack<>();
        stack.push(new Pair<Integer,TreeNode>(1, root));
        int depth = 0;
        while(!stack.isEmpty()){
            Pair<Integer,TreeNode>curr = stack.pop();
            TreeNode currNode = curr.getValue();
            if(curr.getKey()>depth){
                depth = curr.getKey();
            }
            if(currNode.left!=null) {
                stack.push(new Pair<Integer,TreeNode>(curr.getKey()+1, currNode.left));
            }
            if(currNode.right!=null) {
                stack.push(new Pair<Integer,TreeNode>(curr.getKey()+1, currNode.right));
            }
        }
        return depth;
    }
}