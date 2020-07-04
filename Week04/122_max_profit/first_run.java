/**
只要知道后一天比前一天价格低就可以套利
*/
class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        for(int i=1;i<prices.length;i++) {
            res += prices[i]>prices[i-1]?prices[i]-prices[i-1]:0;
        }
        return res;
    }
}