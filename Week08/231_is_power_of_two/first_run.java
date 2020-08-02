/**
位运算直接判断是否只有1个1即可
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n>0) && (n&(n-1)) == 0;
    }
}