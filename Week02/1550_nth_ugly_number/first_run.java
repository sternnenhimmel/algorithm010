/**
总体而言，这个题目动态规划比较清晰，也是最快的，所以首先采用动态规划来实现
*/
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int a=0,b=0,c=0;
        dp[0]=1;
        for(int i=0;i<n-1;i++) {
            int dpa=dp[a]*2;
            int dpb=dp[b]*3;
            int dpc=dp[c]*5;
            int minv = Math.min(Math.min(dpa,dpb),dpc);
            if(dpa==minv) a++;
            if(dpb==minv) b++;
            if(dpc==minv) c++;
            dp[i+1]=minv;
        }
        return dp[n-1];
    }
}