/**
这次直接考虑自底向上开始写循环
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m<=0){
            return 0;
        }
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[] row = new int[n];
        row[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            if(obstacleGrid[m-1][i]==0){
                row[i]=row[i+1];
            }else{
                row[i]=0;
            }
        }
        for(int i=m-2; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(obstacleGrid[i][j]==1) {
                    row[j]=0;
                }else {
                    if(j==n-1) {
                        row[j]=row[j];
                    } else {
                        row[j]=row[j]+row[j+1];
                    }
                }
            }
        }
        return row[0];
    }
}