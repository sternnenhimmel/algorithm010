/**
按照课程的方法，自己撸一次并查集代码，跑出来神速
*/
class Solution {
    public int findCircleNum(int[][] M) {
        if(M.length==0||M[0].length==0) {
            return 0;
        }
        if(M.length!=M[0].length) {
            return 0;
        }
        Union union = new Union(M.length);
        for(int i=0;i<M.length;i++) {
            for(int j=i;j<M[0].length;j++) {
                if(M[i][j]==1) {
                    union.fuse(i,j);
                }
            }
        }
        return union.count;
    }

    class Union{
        int count;
        int[] parent;
        Union(int cnt){
            this.count = cnt;
            this.parent = new int[cnt];
            for(int i=0;i<cnt;i++){
                parent[i]=i;
            }
        }
        int find(int p) {
            while (parent[p]!=p) {
                p = parent[p];
            }
            return p;
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