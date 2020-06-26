/**
首先还是用标准的回溯算法来解答
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();
        boolean[]used = new boolean[nums.length];
        permuteUnique(used,res,new LinkedList<>(),nums);
        return res;
    }

    void permuteUnique(boolean[]used, List<List<Integer>>res, Deque<Integer>temp, int[] nums){
        if(temp.size()==used.length){
            res.add(new LinkedList<>(temp));
        }
        for(int i=0; i<used.length; i++) {
            if(used[i] || i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
            used[i]=true;
            temp.addLast(nums[i]);
            permuteUnique(used,res,temp,nums);
            temp.removeLast();
            used[i]=false;
        }
    }
}