/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<Integer, Integer>map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||preorder.length!=inorder.length){
            return null;
        }
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode helper(int[]preorder,int pleft,int pright, int[]inorder, int inleft, int inright){
        if(pleft>pright||inleft>inright){
            return null;
        }
        TreeNode node = new TreeNode(preorder[pleft]);
        int inorderIdx = map.get(preorder[pleft]);
        node.left = helper(preorder, pleft+1,pleft+inorderIdx-inleft,inorder,inleft,inorderIdx-1);
        node.right = helper(preorder,pleft+inorderIdx-inleft+1,pright,inorder,inorderIdx+1,inright);
        return node;
    }
}