/**
先用自顶向下递归，相对比较简单
*/
class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=1 || n<=1) {
            return 1;
        }
        int[][]grid = new int[m][n];
        return fib(m-1,n-1,grid);
    }

    int fib(int m, int n, int[][]grid) {
        if(m<=0 || n<=0) {
            return 1;
        }
        if(grid[m][n]==0){
            grid[m][n] = fib(m-1, n, grid) + fib(m,n-1,grid);
        }
        return grid[m][n];
    }
}