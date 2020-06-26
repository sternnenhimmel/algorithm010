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
 看题解后发现可以通过递归解决，核心是要定义好递归的结束条件，即左子树和右子树都包含p或者q
 */
class Solution {

    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) {
            return null;
        }
        helper(root,p,q);
        return ans;
    }

    boolean helper(TreeNode node, TreeNode p, TreeNode q){
        if(node==null){
            return false;
        }
        boolean left = helper(node.left,p,q);
        boolean right = helper(node.right,p,q);
        if((node==p||node==q)&&(left||right)){
            ans=node;
        }
        if(left&&right){
            ans=node;
        }
        return node==p||node==q||left||right;
    }

}