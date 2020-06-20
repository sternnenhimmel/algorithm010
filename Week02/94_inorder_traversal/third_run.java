/**
题解里面还有一种把二叉树线性化的方法，即只要一个节点的左子树存在，那么当前节点不应该被访问，并且应该把当前节点放在左子树的最右边，即左子树访问完了才能访问当前节点。如果左子树不存在，则访问当前节点并进入右子树
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        TreeNode curr = root;
        while (curr!=null) {
            if(curr.left!=null) {
                TreeNode pre = curr.left;
                while(pre.right!=null) {
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode tmp = curr.left;
                curr.left = null;
                curr = tmp;
            } else {
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }
}