/**
按照课程方法用dp求解
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null||text2==null||text1.length()<=0||text2.length()<=0) {
            return 0;
        }
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] grid = new int[ch1.length][ch2.length];
        for(int i=0; i<ch1.length; i++){
            for(int j=0;j<ch2.length;j++) {
                grid[i][j]=-1;
            }
        }
        return dp(ch1,ch2,ch1.length-1,ch2.length-1,grid);
    }

    int dp(char[]ch1, char[]ch2, int m, int n, int[][]grid) {
        if(m<0||n<0){
            return 0;
        }
        if(grid[m][n]<0) {
            if(ch1[m]==ch2[n]) {
                grid[m][n] = dp(ch1,ch2,m-1,n-1,grid)+1;
            }else {
                int v1 = dp(ch1,ch2,m-1,n,grid);
                int v2 = dp(ch1,ch2,m,n-1,grid);
                grid[m][n] = Math.max(v1, v2);
            }
        }
        return grid[m][n];
    }
}