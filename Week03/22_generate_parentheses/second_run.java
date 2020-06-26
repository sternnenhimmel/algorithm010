/**
看题解以后，发现这个题目可以想象成一个树的遍历，既然是树的遍历，那么栈和递归代表深度遍历的话，用广度遍历一样可以在同样时间复杂度下面完成任务，只是广度遍历需要自己创建节点以及queue
*/
class Solution {

    class Node{
        int left;
        int right;
        String res;
        public Node(int l, int r, String re) {
            left = l;
            right = r;
            res = re;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String>res = new ArrayList<>();
        Queue<Node>queue = new LinkedList<>();
        Node root = new Node(n,n,"");
        queue.add(root);
        Node curr;
        while(!queue.isEmpty()) {
            curr = queue.remove();
            if(curr.left==0 && curr.right ==0) {
                res.add(curr.res);
            }
            if(curr.left>0){
                queue.add(new Node(curr.left-1,curr.right,curr.res+"("));
            }
            if(curr.right>curr.left){
                queue.add(new Node(curr.left,curr.right-1,curr.res+")"));
            }
        }
        return res;
    }
}