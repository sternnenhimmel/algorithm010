/**
这个题可以比较容易写出动态规划的递归方程：
f(n) = min(f(n-k[0]),f(n-k[1])...) + 1
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount <=0){
            return 0;
        }
        if(coins==null || coins.length<=0) {
            return -1;
        }
        int[] memo = new int[amount];
        return dp(coins, amount, memo);
    }
    int dp(int[] coins, int amount, int[]memo) {
        if(amount==0) {
            return 0;
        }
        if(amount<0) {
            return -1;
        }
        if(memo[amount-1] == 0) {
            int res = -1;
            for(int coin: coins) {
                int current = dp(coins, amount-coin, memo);
                if((current>=0 && res<0)||(current>=0&&current<res)) {
                    res = current;
                }
            }
            if(res>=0) {
                res = res +1;        
            }
            memo[amount-1] = res;
        }
        return memo[amount-1];
    }
}