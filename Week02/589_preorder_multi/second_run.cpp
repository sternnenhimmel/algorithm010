/**
然后尝试用迭代完成
*/
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int>result;
        if (!root) {
            return result;
        }
        stack<Node*> stack;
        Node* curr = root;
        stack.push(curr);
        while(!stack.empty()) {
            curr = stack.top();
            stack.pop();
            result.push_back(curr->val);
            if(curr->children.size()>0) {
                reverse(curr->children.begin(), curr->children.end());
                for(int i=0; i<curr->children.size(); i++) {
                    stack.push(curr->children[i]);
                }
            }
        }
        return result;
    }
};