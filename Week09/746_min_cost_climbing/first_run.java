/**
简单的动态规划，dp(n) = min(dp(n-1),dp(n-2)) + cost(n)
*/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<=1) {
            return 0;
        }
        int f1 = cost[0], f2=cost[1];
        for(int i=2; i<cost.length; i++) {
            int f3 = Math.min(f1,f2)+cost[i];
            f1=f2;
            f2=f3;
        }
        return Math.min(f1,f2);
    }
}