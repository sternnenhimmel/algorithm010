/**
这个题目和打家劫舍1比较相似，区别在于有个环，可以分为是否打劫第一家来计算
*/
class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length<=0){
            return 0;
        }
        if(nums.length==1) {
            return nums[0];
        }
        return Math.max(robSub(Arrays.copyOfRange(nums, 0, nums.length-1)),robSub(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    int robSub(int[] nums) {
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