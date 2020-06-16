/**
最后是双指针法进行夹逼，用o(1)的空间复杂度和o(n)的时间复杂度完成任务
*/
class Solution {
public:
    int trap(vector<int>& height) {
        if(height.size()==0) {
            return 0;
        }
        int l = 0;
        int r = height.size() -1;
        int leftmax=height[l];
        int rightmax = height[r];
        int total = 0;
        while(r>l) {
            if(leftmax>rightmax) {
                r--;
                if(height[r]<rightmax) {
                    total += rightmax - height[r];
                } else {
                    rightmax = height[r];
                }
            } else {
                l++;
                if(height[l]<leftmax) {
                    total += leftmax - height[l];
                } else {
                    leftmax = height[l];
                }
            }
        }
        return total;
    }
};