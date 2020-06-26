
/**
首先，用时间空间复杂度最优的动态规划来过一遍这个题目
*/
class Solution {
    public int climbStairs(int n) {
        if(n<=3) return n;
        int f1=1, f2=2, f3=3;
        for(int i=3; i<=n; i++) {
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }
}