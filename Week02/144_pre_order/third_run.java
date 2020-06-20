/**
最后再来尝试中序遍历中见过的莫斯利遍历法，不断把当前节点的右子树嫁接到左子树的最右边，以保证右子树最后才被访问
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null ) {
            result.add(curr.val);
            if (curr.left != null) {
                if(curr.right!=null) {
                    TreeNode pre = curr.left;
                    while(pre.right!=null) {
                        pre = pre.right;
                    }
                    pre.right = curr.right;
                    curr.right = null;
                }
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return result;
    }

}