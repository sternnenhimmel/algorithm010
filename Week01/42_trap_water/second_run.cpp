/**
接下来用动态规划法，求出每个柱子的最大左边界和最大右边界，然后再求积水总和，这个做法的时间和空间复杂度都是o(n)
*/
class Solution {
public:
    int trap(vector<int>& height) {
        int leftmax = 0;
        vector<int>leftmaxVec(height.size());
        for(int i=0;i <height.size(); i++) {
            if(height[i] >leftmax) {
                leftmax = height[i];
                leftmaxVec[i] = height[i];
            } else {
                leftmaxVec[i] = leftmax;
            }
        }
        int rightmax = 0;
        vector<int>rightmaxVec(height.size());
        for(int i=height.size()-1; i>=0; i--) {
            if(height[i] > rightmax) {
                rightmax = height[i];
                rightmaxVec[i] = height[i];
            } else {
                rightmaxVec[i] = rightmax;
            }
        }
        int total = 0;
        for(int i=0; i< height.size(); i++) {
            int lower = leftmaxVec[i] > rightmaxVec[i] ? rightmaxVec[i] :leftmaxVec[i];
            total += lower - height[i];
        }
        return total;
    }
};