/**
这个看起来可以直接用dp来做，因为每次只能向下或者右移动一步，所以dp方程为：
dp[m][n] = min(dp[m][n-1],dp[m-1][n]) + grid[m][n]
*/
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length<=0 || grid[0].length<=0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[]memo = new int[n+1];
        memo[n] = Integer.MAX_VALUE;
        memo[n-1] = grid[m-1][n-1];
        for(int i=n-2; i>=0; i--) {
            memo[i] = memo[i+1] + grid[m-1][i];
        }
        for(int i = m-2; i>=0; i--) {
            for ( int j = n-1; j>=0; j--) {
                memo[j] = Math.min(memo[j+1], memo[j]) + grid[i][j];
            }
        }
        return memo[0];
    }
}