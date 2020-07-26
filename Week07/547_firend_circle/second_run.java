/**
再来用dfs实现一边，当作复习
*/
class Solution {
    public int findCircleNum(int[][] M) {
        if(M.length==0||M[0].length==0) {
            return 0;
        }
        if(M.length!=M[0].length) {
            return 0;
        }
        int res = 0;
        boolean[]visited = new boolean[M.length];
        for(int i=0;i<M.length;i++) {
            if(!visited[i]) {
                res++;
                dfs(i, visited, M);
            }
        }
        return res;
    }
    void dfs(int i, boolean[]visited, int[][]M) {
        for(int j=0; j<M.length;j++) {
            if(M[i][j]==1&&!visited[j]){
                visited[j] = true;
                dfs(j, visited, M);
            }
        }
    }
}