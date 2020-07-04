/**
老规矩，先上二分法
*/
class Solution {
    public boolean isPerfectSquare(int num) {
        long left=0L, right = (long)num;
        long mid = 0;
        while(right >= left) {
            mid = (left+right)/2;
            long curr = mid*mid;
            if(curr==(long)num){
                return true;
            }
            if(curr > num) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}