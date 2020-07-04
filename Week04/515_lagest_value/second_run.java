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
 用dfs也来解一下，这个最快，1ms
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>res = new ArrayList<>();
        if(root==null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }
    void dfs(TreeNode node, int level, List<Integer>res) {
        if (node == null) return;
        if (level > res.size()-1) {
            res.add(node.val);
        }
        if (node.val > res.get(level)) {
            res.set(level, node.val);
        }
        dfs(node.left, level+1, res);
        dfs(node.right, level+1, res);
    }
}