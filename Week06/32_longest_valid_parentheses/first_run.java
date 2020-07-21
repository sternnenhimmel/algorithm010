/**
此题也可以用动态规划来解，但是子问题的定义和状态转移方程较难
考虑到第n个数的情况
1. 如果此时为左括号，那么以它结尾的子串显然不符合要求，即f(n) = 0;
2. 如果此时为右括号，那么以它结尾子串需要判断是否前面有左括号与之匹配
 2.1 判断n-f(n-1)-1位置的字符，如果是左括号，则正好组合成一对，此时积累长度为f(n-1) + 2 
 2.2 如果n-f(n-1)-2处的值不为0，那么刚好可以把这一块也连进去
*/
class Solution {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()<=1) {
            return 0;
        }
        int max = 0;
        int[] memo = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                memo[i] = 0;
            } else {
                if(i>0) {
                    if(i-memo[i-1]-1>=0) {
                        if(s.charAt(i-memo[i-1]-1)=='(') {
                            memo[i]=2+memo[i-1];
                            max = Math.max(memo[i], max);
                            if(i-memo[i-1]-2>0 && memo[i-memo[i-1]-2]>0) {
                                memo[i] += memo[i-memo[i-1]-2];
                                max = Math.max(memo[i], max);
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}