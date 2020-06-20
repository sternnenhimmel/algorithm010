/**
改用双端队列，用线性时间来实现
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
        Deque<Integer> deque = new ArrayDeque<>();
        int low=0,high=0;
        int[] result = new int[n-k+1];
        while(high<n) {
            if(high-low<k){
                cleanDeque(deque,high,nums);
                deque.add(high);
                high++;
            } else {
                result[low] = nums[deque.getFirst()];
                if(deque.getFirst() == low) {
                    deque.removeFirst();
                }
                low++;
            }
            result[low] = nums[deque.getFirst()];
        }
        return result;
    }

    private void cleanDeque(Deque<Integer>deque, int current, int[] nums) {
        while(!deque.isEmpty() && nums[current] > nums[deque.getLast()]) {
            deque.removeLast();
        }
    }
}