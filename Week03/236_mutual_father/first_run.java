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
 想到一个方法，让p先沿着树爬到根，记录路径，再让q沿着树往上爬，第一次遇到记录过的节点，就是最短公共祖先了
 */
class Solution {
    Map<Integer,TreeNode>map = new HashMap<>();
    Set<Integer>set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) {
            return null;
        }
        constructFatherMap(root);
        while(p!=null){
            set.add(p.val);
            p = map.get(p.val);
        }
        TreeNode result = root;
        while(q!=null) {
            if(set.contains(q.val)){
                return q;
            }
            q=map.get(q.val);
        }
        return root;
    }

    void constructFatherMap(TreeNode root) {
        if(root.left!=null) {
            map.put(root.left.val, root);
            constructFatherMap(root.left);
        }
        if(root.right!=null) {
            map.put(root.right.val, root);
            constructFatherMap(root.right);
        }
    }
}