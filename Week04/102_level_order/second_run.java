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
 接下来尝试用dfs，先用递归
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, root, res);
        return res;
    }

    void dfs(int level, TreeNode node, List<List<Integer>> res) {
        if(res.size() < level+1) {
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(level);
        list.add(node.val);
        if(node.left!=null) {
            dfs(level+1, node.left, res);
        }
        if(node.right !=null ) {
            dfs(level+1, node.right, res);
        }
    }
}