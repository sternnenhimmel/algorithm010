/**
题解中还有一个按递归实现的方法，由于递归是基于栈而不是基于队列的，所以这种方法其实不是真正的广度遍历，只不过最后结果呈现上和按照广度遍历一致，所以也能被accept
*/
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root!=null){
            traverse(root, 0);
        }
        return result;
    }

    void traverse(Node node, int level) {
        if (result.size()<=level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(node.val);
        for(Node child: node.children) {
            traverse(child, level+1);
        }
    }
}