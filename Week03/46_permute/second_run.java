/**
在高票题解中有个swap算法，看上去很不错，这边也加以实现
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer>list = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        List<List<Integer>>res = new ArrayList<>();
        permute(res, list, 0);
        return res;
    }
    void permute(List<List<Integer>>res, List<Integer>list, int begin) {
        if(begin==list.size()){
            res.add(new LinkedList<>(list));
        }
        for (int i=begin; i< list.size();i++){
            swap(list, begin, i);
            permute(res, list, begin+1);
            swap(list, begin, i);
        }
    }

    void swap(List<Integer>list, int a, int b){
        if(a==b){
            return;
        }
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}