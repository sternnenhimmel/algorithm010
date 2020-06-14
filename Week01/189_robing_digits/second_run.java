/*
下面看看反转法，反转法主要就是基于所有的元素在轮换结束后都会落在(i+k)%n的位置这么一个事实，
先反转所有元素，再反转前k个元素和后n-k个元素得到结果，反转法的时间复杂度也是o(n)，空间复杂度是o(1)，但是反转法中每个元素被轮换3次，相对来说，比不上环形轮换法
*/
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k = k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    /**
     * reverse 本身用双指针法实现
     */
    private void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while(end > start) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}