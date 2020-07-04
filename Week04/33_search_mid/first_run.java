/**
直接用二分查找，被分割的两边必有一边是单调的
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left=0,right=nums.length-1;
        int mid=0;
        while(left<=right) {
            mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[left]){
                if(nums[mid]>target && nums[left]<=target) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if(nums[mid]<target && nums[right]>=target) {
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}