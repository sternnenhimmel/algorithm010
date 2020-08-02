/**
用动态规划+位操作求解
*/
class Solution {
    public int[] countBits(int num) {
        int[]res = new int[num+1];
        res[0]=0;
        if(num==0) {
            return res;
        }
        res[1]=1;
        for(int i=2;i<num+1;i++) {
            if((i&1)==1){
                res[i]=res[i>>1] +1;
            }else {
                res[i]=res[i>>1];
            }
        }
        return res;
    }
}