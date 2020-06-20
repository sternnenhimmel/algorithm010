/**
首先，用堆来实现（实际上在leetcode超时了。。）
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(n*k==0) {
            return new int[0];
        }
        if(k==1){
            return nums;
        }
        //创建一个优先堆，并把前k个放进去
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i<k; i++) {
            pq.add(nums[i]);
        }
        int count = n-k+1;
        int[] result = new int[count];
        result[0]=pq.peek();
        for(int i=k; i<n; i++) {
            int start = i-k;
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            result[start+1]=pq.peek();
        }
        return result;
    }
}
