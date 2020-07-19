/**
这个题和最大连续和相似，但是因为乘法有负负得正的问题，所以需要同时记录最小负值和最大值。dp方程：
max(n) = max(f(n)*max(n-1),f(n)*min(n-1),f(n),0)
min(n) = min(f(n)*max(n-1),f(n)*min(n-1),f(n),0)
*/
class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length<=0) {
            return 0;
        }
        int[]maxes = new int[nums.length];
        int[]mins = new int[nums.length];
        if(nums[0]>0){
            maxes[0] = nums[0];
        } else {
            mins[0] = nums[0];
        }
        int max_v = nums[0];
        for(int i=1; i<nums.length; i++) {
            int v1 = maxes[i-1] * nums[i];
            int v2 = mins[i-1] * nums[i];
            int v3 = nums[i];
            int v4 = 0;
            maxes[i] = Math.max(v1, Math.max(v2, Math.max(v3, v4)));
            mins[i] = Math.min(v1, Math.min(v2, Math.min(v3, v4)));
            max_v = Math.max(max_v, maxes[i]);
        }
        return max_v;
    }
}