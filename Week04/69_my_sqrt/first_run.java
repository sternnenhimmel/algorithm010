/**
直接来一发牛顿法，o(logN)解决，而且是二次收敛
*/
class Solution {
    public int mySqrt(int x) {
        long a = x;
        while(a*a>x) {
            a=(a+x/a)/2;
        }
        return (int)a;
    }
}