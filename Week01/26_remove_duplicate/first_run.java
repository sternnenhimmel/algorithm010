
/**
暴力1:
每次遇到重复元素就进行删除并将后面的元素往前拷贝，这样时间复杂度将是O(n^2)
*/

/**
快慢双指针法：
两个指针一起往前移动，如果下一个元素小于等于当前元素，第一个指针停下来，第二个指针继续往前跑找到比第一个指针大的数，并用第二个指针指向的内容改写第一个指针指向的内容，第二个指针走到底则结束，时间复杂度为o(n)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                i++;
                nums[i]= nums[j];
            }
        }
        return i+1;
    }
}


