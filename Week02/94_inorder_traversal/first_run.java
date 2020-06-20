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
 按照课程的方法写出来中序遍历，算法的时间复杂度是o(n),
 空间复杂度平均情况下是o(lgn)，但是最坏情况下会退化成链表结构，空间复杂度变成o(n)
  */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer>result) {
        if(root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }
}