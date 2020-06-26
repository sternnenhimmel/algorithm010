/**
首先想到的是用哈希表，o(n)即可完成
*/
class Solution {
    public int majorityElement(int[] nums) {
        int limit = nums.length/2+1;
        Map<Integer, Integer>map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>=limit){
                return nums[i];
            }
        }
        return 0;
    }
}