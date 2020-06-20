/*
由于个人认为两遍hash法无法应对2+2=4这种case，所以这里仅采用一遍hash法实现
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int counterpart = target - nums[i];
            if (map.containsKey(counterpart)) {
                return new int[]{map.get(counterpart),i};
            }
            map.put(nums[i],i);
        }
        throw new RuntimeException("没有找到合适的结果");
    }
}