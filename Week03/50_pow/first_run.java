/**
用分治的思想，把乘法次数降低到o(logN)
*/
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        long N = (long)n;
        if (N<0){
            N = -N;
            x=1/x;
        }
        return helper(x,N);
    }

    double helper(double x, long n){
        if(n==1L){
            return x;
        }
        long half = n/2;
        long remain = n%2;
        double halfResult = helper(x,half);
        if(remain>0){
            return x* halfResult * halfResult;
        } else {
            return halfResult * halfResult;
        }
    }
}