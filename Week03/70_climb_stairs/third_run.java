
/**
看了题解，发现还有个通过求幂进行加速，把时间复杂度进一步降低到o(log N)的方法，牛逼，给跪，这边实现一下
*/
class Solution {
    int[] calculated;
    public int climbStairs(int n) {
        int[][] q = {{1,1},{1,0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    int[][] pow(int[][]q, int n) {
        int[][] ret = {{1,0},{0,1}};
        while(n>0) {
            if((n & 1)>0) {
                ret = mul(ret,q);
            }
            n = n >>= 1;
            q=mul(q,q);
        }
        return ret;
    }

    int[][]mul(int[][]a, int[][]b) {
        int[][]ret = new int[2][2];
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                ret[i][j] = a[i][0]*b[0][j] + a[i][1]*b[1][j];
            }
        }
        return ret;
    }
}