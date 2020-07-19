/**
简单的dp，假设要计算偷到第n个房子的最大值，那么f(n) = Math.max(f(n-2) + nums[n], f(n-1))
*/
class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int max_v = 0;
        int[] maxMemo = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int beforeMax_2 = i>=2?maxMemo[i-2]:0;
            int beforeMax_1 = i>=1?maxMemo[i-1]:0;
            int currMax = Math.max(beforeMax_1, beforeMax_2+nums[i]);
            maxMemo[i] = currMax;
            max_v = Math.max(currMax, max_v);
        }
        return max_v;
    }
}