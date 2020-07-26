/**
这个题之前用dfs实现过，再次遇到尝试用并查集解决，不过这次看起来还没dfs快。。
*/
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length<=0 || grid[0].length<=0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Union un = new Union(grid);
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]=='1') {
                    grid[i][j]='0';
                    if(i-1>=0 && grid[i-1][j]=='1') un.fuse(i*n+j,(i-1)*n+j);
                    if(j-1>=0 && grid[i][j-1]=='1') un.fuse(i*n+j,i*n+j-1);
                    if(i+1<m && grid[i+1][j]=='1') un.fuse(i*n+j,(i+1)*n+j);
                    if(j+1<n && grid[i][j+1]=='1') un.fuse(i*n+j,i*n+j+1);
                }
            }
        }
        return un.count;
    }

    class Union{
        int count = 0;;
        int[] parent;
        Union(char[][] grid){
            int m = grid.length;
            int n = grid[0].length;
            this.parent = new int[m*n];
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    int k = i*n+j;
                    if(grid[i][j]=='1') {
                        parent[k]=k;
                        count++;
                    }else {
                        parent[k]=-1;
                    }
                }
            }
        }
        int find(int p) {
            if (parent[p]!=p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }
        void fuse(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            if(rootI==rootJ) {
                return;
            }
            parent[rootJ] = rootI;
            count--;
        }
    }
}