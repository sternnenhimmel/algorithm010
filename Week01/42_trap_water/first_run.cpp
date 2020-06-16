/**
这个题一开始没什么想法，所以直接看了一下题解，发现这个题最重要的一点在于，对于每个柱子，相对于它，左边最高的柱子和右边最高的柱子中的较低者和它的高度差决定了它可以积多少水，以下实现各个方法。首先是暴力法，遍历每个柱子，找到每个柱子左边的最大值和右边的最大值
*/
class Solution {
public:
    int trap(vector<int>& height) {
        int total = 0;
        for (int i=0; i<height.size(); i++) {
            int leftmax = 0;
            for (int j=0; j<i; j++) {
                if (height[j] > leftmax) {
                    leftmax = height[j];
                }
            }
            if(leftmax > height[i]) {
                int rightmax = 0;
                for (int j=i+1; j<height.size(); j++) {
                    if (height[j]>rightmax) {
                        rightmax = height[j];
                    }
                }
                if (rightmax>height[i]) {
                    int diff = rightmax >leftmax? leftmax-height[i] : rightmax-height[i];
                    total += diff;
                }
            }
        }
        return total;
    }
};