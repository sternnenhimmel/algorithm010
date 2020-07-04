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
 最后再用自己的栈来实现，这个好慢，7ms
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>res = new ArrayList<>();
        if(root==null) {
            return res;
        }
        Stack<Pair<Integer, TreeNode>>stack = new Stack<>();
        stack.add(new Pair<>(0, root));
        while(!stack.isEmpty()) {
            Pair<Integer, TreeNode> pair = stack.pop();
            TreeNode node = pair.getValue();
            if(res.size()-1 < pair.getKey()){
                res.add(node.val);
            }
            if(node.val > res.get(pair.getKey())) {
                res.set(pair.getKey(), node.val);
            }
            if(node.left!=null) {
                stack.push(new Pair<>(pair.getKey()+1, node.left));
            } 
            if(node.right !=null) {
                stack.push(new Pair<>(pair.getKey()+1, node.right));
            }
        }
        return res;
    }
}