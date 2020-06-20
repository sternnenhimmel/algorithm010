/**
首先是正常的递归
*/
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int>result;
        if(root == nullptr) {
            return result;
        }
        postorder(root, result);
        return result;
    }

private:
    void postorder(Node* node, vector<int>&list) {
        if(node->children.size()>0) {
            for(Node* child: node->children) {
                postorder(child, list);
            }
        }
        list.push_back(node->val);
    }
};