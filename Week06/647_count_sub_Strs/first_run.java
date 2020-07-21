/**
此题有o(n^2)种子串，每个子串判断是否为回文，需要o(n)的时间，因此暴力解法会需要o(n^2)的时间。但是每一个字符串其实还有其自己的子串，如果已知其子串是否为回文，那么只要o(1)的时间就能判断当前子串是否为回文，这样可以把总时间缩短到o(n^2)
*/
class Solution {
    public int countSubstrings(String s) {
        if(s==null||s.length()==0) {
            return 0;
        }
        int[][]memo = new int[s.length()][s.length()];
        char[]ss = s.toCharArray();
        int count = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=i; j<s.length(); j++) {
                if(dp(memo,i,j,ss)==2) {
                    count++;
                }
            }
        }
        return count;
    }
    int dp(int[][]memo, int i, int j, char[]s) {
        if(i==j) {
            return 2;
        }
        if(memo[i][j]==0) {
            if(s[i]!=s[j]) {
                memo[i][j]=1;
            }else {
                if(j-i==1) {
                    memo[i][j]=2;
                } else {
                    memo[i][j] = dp(memo, i+1, j-1, s);
                }
            }
        }
        return memo[i][j];
    }
}