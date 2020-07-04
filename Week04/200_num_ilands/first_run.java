/**
做一次轮训，每遇到一个1，就用dfs把周围的1都变成0
*/
class Solution {
    int row=0;
    int col=0;
    char mygrid[][];
    public int numIslands(char[][] grid) {
        int res=0;
        if(grid.length<=0 || grid[0].length<=0) {
            return res;
        }
        mygrid=grid;
        row=grid.length;
        col=grid[0].length;
        for(int i=0; i< row;i++) {
            for(int j=0; j<col;j++) {
                if(grid[i][j]=='1') {
                    res++;
                    dfs(i,j);
                }
            }
        }
        return res;
    }

    void dfs(int i, int j) {
        mygrid[i][j]='0';
        if(i>0&&mygrid[i-1][j]=='1') dfs(i-1,j);
        if(j>0&&mygrid[i][j-1]=='1') dfs(i,j-1);
        if(i<row-1&&mygrid[i+1][j]=='1') dfs(i+1,j);
        if(j<col-1&&mygrid[i][j+1]=='1') dfs(i,j+1);
    }
}