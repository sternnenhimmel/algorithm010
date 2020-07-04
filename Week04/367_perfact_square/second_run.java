/**
再来一发牛顿法，完美了
*/
class Solution {
    public boolean isPerfectSquare(int num) {
        long a = (long)num;
        while(a*a>num){
            a=(a+num/a)/2;
        }
        return a*a == (long)num;
    }
}