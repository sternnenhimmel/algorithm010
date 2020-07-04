/**
这个题其实就是要用二分查找找出旋转的点
*/
class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int left=0, right=nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(mid<nums.length-1&&nums[mid]>nums[mid+1]) {
                return nums[mid+1];
            }
            if(mid>0&&nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            //除去上面2种情况，出现问题的点肯定在左边或者右边不遵守条件的地方
            if(nums[mid]<nums[left]){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        //最终都没找到变异点，那就是每变异，第一个就是最小值
        return nums[0];
    }
}