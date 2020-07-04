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
 先按照最直观的层序遍历实现
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer>thisLevel = new ArrayList<>();
            for(int i=0; i< size; i++) {
                TreeNode node = queue.remove();
                thisLevel.add(node.val);
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
            res.add(thisLevel);
        }
        return res;
    }
}