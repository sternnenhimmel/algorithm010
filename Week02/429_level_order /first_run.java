/**
树的层序遍历，基于队列进行，每次处理一层
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> deque = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer>level = new ArrayList<>();
            for(int i=0; i<size; i++) {
                Node curr = deque.removeFirst();
                level.add(curr.val);
                for (Node node: curr.children) {
                    deque.addLast(node);
                }
            }
            result.add(level);
        }
        return result;
    }
}