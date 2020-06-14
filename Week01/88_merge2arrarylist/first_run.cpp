/*
思路：缔造一个新的数组，然后依次比较nums1和nums2头部最小的元素，把较小者copy到目标数组，并且往后移动一格
*/
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if (m==0) {
            nums1 = nums2;
            return;
        }
        if (n==0) {
            return;
        }
        vector<int>result(m+n);
        int idx1=0, idx2=0;
        int current = 0;
        while (idx1 < m && idx2 < n) {
            if(nums1[idx1] > nums2[idx2]) {
                result[current] = nums2[idx2];
                idx2 ++;
            } else {
                result[current] = nums1[idx1];
                idx1++;
            }
            current ++;
        }
        if (idx1 == m) {
            std::memcpy(&result[current], &nums2[idx2], (n-idx2)*sizeof(int));
        } else {
            std::memcpy(&result[current], &nums1[idx1], (m-idx1)*sizeof(int));
        }
        nums1 = result;
    }
};
