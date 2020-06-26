/**
这个题也可以用递归的方法来做
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        List<Integer>remain = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            remain.add(nums[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        permute(res, remain, new ArrayList<>());
        return res;
    }
    void permute(List<List<Integer>>res, List<Integer>remain, List<Integer>curr) {
        if(remain.size()==0){
            res.add(curr);
            return;
        }
        for(int i=0;i<remain.size();i++){
            List<Integer>newList = new ArrayList<>(curr);
            List<Integer>newRemain = new LinkedList<>(remain);
            int number = newRemain.remove(i);
            newList.add(number);
            permute(res,newRemain,newList);
        }
    }
}