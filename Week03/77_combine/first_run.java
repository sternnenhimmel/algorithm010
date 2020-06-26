/**
排列组合题，数学上理论上来说有n(n-1)...(n-k+1)/k!种组合
可以想象成从左往右一点点填满k个空格
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        constructNumberList(0,1, k, n, res, new ArrayList<>(k));
        return res;
    }

    void constructNumberList(int count, int start, int k, int n, List<List<Integer>> res,List<Integer>curr) {
        if(count == k) {
            res.add(curr);
            return;
        }
        for(int i=start; i<= n; i++){
            List<Integer> newList = new ArrayList<>(curr);
            newList.add(i);
            constructNumberList(count+1, i+1, k, n, res, newList);
        }
    }
}