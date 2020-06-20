/**
然后尝试用栈来解决
*/
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int>result;
        if(root == nullptr) {
            return result;
        }
        Node* curr = root;
        stack<Node*> stack;
        stack.push(curr);
        while(!stack.empty()){
            curr = stack.top();
            stack.pop();
            result.push_back(curr->val);
            if(curr->children.size()>0) {
                for(auto node: curr->children) {
                    stack.push(node);
                }
            }
        }
        reverse(result.begin(),result.end());
        return result;
    }

};