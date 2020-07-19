/**
一开始没有思路，看了题解后发现，主要问题在于没能很好的写出递归方程。
本题的递归方程可以总结为:f(n) = f(n-1)>0? f(n-1)>0+f(n) : f(n)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length<=0){
            return 0;
        }
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            nums[i] = nums[i-1]>0? nums[i-1]+nums[i] :nums[i];
            if(nums[i]>max) {
                max = nums[i];
            }
        }
        return max;
    }
}