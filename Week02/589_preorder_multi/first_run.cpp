/**
首选还是用递归法来完成
*/
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int>result;
        if (!root) {
            return result;
        }
        preorder(result, root);
        return result;
    }

    void preorder(vector<int>&vec, Node* node){
        vec.push_back(node->val);
        for(auto n: node->children) {
            preorder(vec, n);
        }
    }
};