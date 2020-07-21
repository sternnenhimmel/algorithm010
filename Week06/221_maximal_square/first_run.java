/**
假设以(i,j)位置为最大正方形结束点，那么此时包含的最大正方形的边长应该是 length = min(f(i-1,j),f(i,j-1))，此时如果位于 (i-length, j-length)的点也是1的话，则(i,j)位置处的最大正方形边长应该是length+1 ,不然即为length 
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length<=0||matrix[0].length<=0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][]dp = new int[m][n];
        int max = 0;
        for(int i=0; i<n; i++) {
            dp[0][i] = matrix[0][i]-'0';
            if(dp[0][i]==1) {
                max = 1;
            }
        }
        for(int i=0; i<m; i++) {
            dp[i][0] = matrix[i][0]-'0';
            if(dp[i][0]==1) {
                max = 1;
            }
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j]=='1') {
                    int len = Math.min(dp[i-1][j],dp[i][j-1]);
                    if(matrix[i-len][j-len]=='1') {
                        dp[i][j]=len+1;
                        max = Math.max(max, dp[i][j]);
                    } else {
                        dp[i][j]=len;
                    }
                }
            }
        }
        return max*max;
    }
}