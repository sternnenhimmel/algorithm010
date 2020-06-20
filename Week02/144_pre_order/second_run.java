 /**
尝试使用栈来解决问题
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()) {
            if(curr==null) {
                curr = stack.pop();
            }
            result.add(curr.val);
            if(curr.right!=null){
                stack.push(curr.right);
            }
            curr = curr.left;
        }
        return result;
    }

}