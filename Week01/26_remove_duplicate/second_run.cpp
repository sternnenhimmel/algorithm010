/**
看了top view以后发现了计数法这种科技，试着写了一个，也提交通过了
 */
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int i=1;
        int cnt = 0;
        for (;i < nums.size(); i++) {
            if (nums[i] == nums[i-1]) {
                cnt++;
            } else {
                nums[i-cnt] = nums[i];
            }
        }
        return i-cnt;
    }
};