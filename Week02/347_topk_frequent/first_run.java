/**
先用哈希表进行统计，然后用priority queue进行排序，时间复杂度是o(n+n*logk)
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==0||k==0) {
            return new int[0];
        }
        //统计个数
        Map<Integer,Integer>map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //建立最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int a: map.keySet()){
            queue.add(a);
            if(queue.size()>k){
                queue.remove();
            }
        }
        //取出结果
        int count = queue.size();
        int[] result = new int[count];
        for(int i=count-1;i>=0;i--){
            result[i] = queue.remove();
        }
        return result;
    }
}