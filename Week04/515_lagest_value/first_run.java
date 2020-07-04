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
 这个直接用广度遍历即可，o(n)时间，跑起来2ms
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>res = new ArrayList<>();
        if(root==null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                if(node.val > max) {
                    max = node.val;
                }
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}