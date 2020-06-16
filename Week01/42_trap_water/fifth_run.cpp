/**
看到个比较有意思的思路，找到最大值所在位置，然后从最大值往左往右非单调递减
*/
class Solution {
public:
    int trap(vector<int>& height) {
        if(height.size()==0) {
            return 0;
        }
        int m = max_element(height.begin(),height.end())-height.begin();
        int total;
        int cur=0;
        for(int i=0;i<m; i++) {
            if(cur>height[i]) {
                total += cur -height[i];
            } else {
                cur = height[i];
            }
        }
        cur=0;
        for(int i=height.size()-1; i>m; i--) {
            if(cur>height[i]) {
                total+=cur-height[i];
            }else{
                cur = height[i];
            }
        }
        return total;
    }
};