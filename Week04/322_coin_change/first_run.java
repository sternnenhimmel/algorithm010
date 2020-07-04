/**
这个题明显不能用贪心，因为硬币的数值是不确定的，并且由于状态树是指数级的，如果用bfs或者dfs，只要结果所需要的硬币多一点就容易超时。但是这个问题的子问题有很强的重复性，所以采用动态规划解题。
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<=0){
            return 0;
        }
        if(coins==null || coins.length==0) {
            return -1;
        }
        Set<Integer>set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for(int c: coins) {
            set.add(c);
            if(c<min){
                min=c;
            }
        }
        Map<Integer,Integer>results = new HashMap<>();
        return dp(set, results, amount, min);
    }

    int dp(Set<Integer>coins, Map<Integer, Integer>results, int amount, int minCoin) {
        if(results.containsKey(amount)) {
            return results.get(amount);
        }
        if(coins.contains(amount)) {
            results.put(amount,1);
            return 1;
        }
        if(amount<minCoin) {
            results.put(amount, -1);
            return -1;
        }
        int res = -1;
        for(int c : coins) {
            if(amount>=c) {
                int temp = dp(coins, results, amount-c, minCoin);
                if(temp>0 && res<0){
                    res = temp;
                } else if (temp>0 && temp<res) {
                    res = temp;
                }
            }
        }
        if(res>0) {
            res++;
        }
        results.put(amount,res);
        return res;
    }
}