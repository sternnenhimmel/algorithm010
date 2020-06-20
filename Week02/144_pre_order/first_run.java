/**
 首先用常规的递归法
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list){
        if (node != null) {
            list.add(node.val);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }
}