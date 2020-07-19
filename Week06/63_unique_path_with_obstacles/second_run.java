/**
再试一下递归，感觉应该要简单一些
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
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                grid[i][j]=-1;
            }
        }
        grid[m-1][n-1]=1;
        return fib(obstacleGrid, grid, 0, 0);
    }

    int fib(int[][]obstacleGrid, int[][]grid, int m, int n) {
        if(m>=grid.length||n>=grid[0].length) {
            return 0;
        }
        if (obstacleGrid[m][n]==1){
            return  0;
        }
        if(grid[m][n]<0){
            grid[m][n] = fib(obstacleGrid, grid, m+1, n)
                            + fib(obstacleGrid, grid, m, n+1);
        }
        return grid[m][n];
    }
}