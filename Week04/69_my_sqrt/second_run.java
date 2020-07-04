/**
再来试试二分查找
*/
class Solution {
    public int mySqrt(int x) {
        long left=0L, right = (long)x;
        long mid = 0;
        while(right >= left) {
            mid = (left+right)/2;
            long curr = mid*mid;
            if(curr==(long)x){
                return (int)mid;
            }
            if(curr > x) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return (int)right;
    }
}