
/*
看了题解以后发现可以用从后往前依次移动2个数组较大值的方法，这样可以把空间复杂度降到1，因此这里也加以实现
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
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while (p1>=0 && p2>=0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2 --;
            }
            p--;
        }
        if (p1<0) {
            std::memcpy(&nums1[0], &nums2[0], (p2+1)*sizeof(int));
        }
    }
};