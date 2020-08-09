/**
先用动态规划求解
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1) {
            return nums.length;
        }
        int[]dp = new int[nums.length];
        dp[0]=1;
        int ans = 1;
        for(int i=1; i<nums.length; i++) {
            
                int temp = 0;
                for(int j=0; j<i;j++) {
                    if(nums[i]>nums[j]) {
                        temp = Math.max(temp, dp[j]);
                    }
                }
                dp[i]=temp+1;
            
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}