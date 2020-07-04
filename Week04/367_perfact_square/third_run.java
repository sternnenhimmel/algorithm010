/**
高票回答里面有个非常神奇的解法，完全平方数=1+3+5+7+...
虽然这个方法的时间复杂度是o(sqrt(N))，比不上二分查找和牛顿
*/
class Solution {
    public boolean isPerfectSquare(int num) {
        int i=1;
        while(num>0){
            num-=i;
            i+=2;
        }
        return num==0;
    }
}