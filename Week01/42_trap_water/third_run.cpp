/**
下面使用栈来进一步减少循环的次数
*/
class Solution {
public:
    int trap(vector<int>& height) {
        std::stack<int> ws;
        int total = 0;
        for (int i=0; i< height.size(); i++) {
            while(!ws.empty() && height[i] > height[ws.top()]) {
                int top = ws.top();
                ws.pop();
                if (ws.empty()) {
                    break;
                }
                int distance = i - ws.top() -1;
                int diff = min(height[ws.top()], height[i]) -height[top];
                total += distance *diff;
            }
            ws.push(i);
        }
        return total;
    }
};