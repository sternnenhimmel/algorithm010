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
 这个题目刚开始看到有点蒙，主要是不知道解码该怎么做，看了题解才发现，解码一样是递归，这里尝试实现
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return null;
        }
        return serialize(root, "");
    }
    String serialize(TreeNode node, String curr) {
        if(node == null) {
            return curr+"null"+",";
        }
        String str = curr+String.valueOf(node.val)+",";
        str = serialize(node.left, str);
        str = serialize(node.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0) return null;
        String[]strs = data.split(",");
        Queue<String>queue = new LinkedList<String>(Arrays.asList(strs));
        return deserialize(queue);
    }

    TreeNode deserialize(Queue<String>queue){
        String str = queue.remove();
        if("null".equals(str)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));