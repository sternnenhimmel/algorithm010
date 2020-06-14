

/**
暴力：每轮每次移动一格，往右移k轮，时间复杂度是o(k*n)
*/

/**
看题解以后，得到轮换法和反转法
先看轮换法，轮换法其实基于2个事实
1. 所有的元素在轮换结束后都会落在(i+k)%n的位置
2. 在进行环状的轮换过程中，只要保证每次轮换是有效的，那么当轮换次数达到n以后，目标也就达成了
*/
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        int cnt = 0;
        int temp1 = 0;
        int temp2 = 0;
        for(int start = 0; cnt < n; start++) {
            int current = (start + k) % n;
            temp1 = nums[start];
            while (current != start) {
                temp2 = nums[current];
                nums[current] = temp1;
                current = (current + k) % n;
                temp1 = temp2;
                cnt++;
            }
            nums[start] = temp1;
            cnt++;
        }
    }
}


