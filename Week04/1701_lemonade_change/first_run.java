/**
由于纸币设计合理，都是可以整除的关系，给每个顾客优先找最大的面值，就有更大概率给每个顾客找零。
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0, cnt10 = 0;
        for(int b : bills) {
            int remain = b-5;
            if(remain>0) {
                int use10 = Math.min(cnt10,remain/10);
                cnt10-=use10;
                remain-=use10*10;
                if(remain>0){
                    int use5 = Math.min(cnt5, remain/5);
                    cnt5-=use5;
                    remain-=use5*5;
                    if(remain>0){
                        return false;
                    }
                }
            }
            if(b==5){
                cnt5++;
            }
            if(b==10) {
                cnt10++;
            }
        }
        return true;
    }
}