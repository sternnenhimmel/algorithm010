/**
在全排列的全球站解法里面就已经发现这个subsets了，这里自己撸一遍
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList<>(), 0, nums);
        return res;
    }

    void subsets(List<List<Integer>> res, List<Integer>curr, int idx, int[]nums){
        if(idx==nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        subsets(res, curr, idx+1, nums);
        curr.add(nums[idx]);
        subsets(res, curr, idx+1, nums);
        curr.remove(curr.size()-1);
    }
}