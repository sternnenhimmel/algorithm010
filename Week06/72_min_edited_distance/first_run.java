/**
这个题比较难做，主要原因是子问题的定义比较困难。看过题解以后尝试自己来写一遍。
这个题使得单词A -> B变得更近一步有三种转换方式
1. 后面插入一个和B最后一个字符相等的字符
2. 删除最后一个字符
3. 替换最后一个字符，需要比较这三种情况哪种更小
*/
class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0) {
            return word2.length();
        }
        if(word2.length()==0) {
            return word1.length();
        }
        char[]arr1 = word1.toCharArray();
        char[]arr2 = word2.toCharArray();
        int n1 = arr1.length, n2 = arr2.length;
        int[][] memo = new int[n1][n2];
        return dp(memo, arr1,arr2,n1-1,n2-1);
    }
    int dp(int[][]memo, char[]arr1, char[]arr2, int i, int j) {
        if(i<0||j<0) {
            return Math.max(i,j) + 1;
        }
        if(memo[i][j] == 0) {
            if(arr1[i] == arr2[j]) {
                memo[i][j] = dp(memo, arr1,arr2,i-1,j-1);
            }else {
                memo[i][j] = 1 + Math.min(dp(memo, arr1,arr2,i-1,j-1),
                Math.min(dp(memo, arr1,arr2,i,j-1),dp(memo, arr1,arr2,i-1,j)));
            }
        }
        return memo[i][j];
    }
}