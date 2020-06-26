
/**
然后改用带记忆的递归来解题，熟悉以下递归模板，时间复杂度是o(n)，空间复杂度是o(n)
*/
class Solution {
    int[] calculated;
    public int climbStairs(int n) {
        calculated = new int[n];
        return climbStairs(n, calculated);
    }

    public int climbStairs(int level, int[]calculated) {
        if(level <= 3) {
            return level;
        }
        int f1;
        if (calculated[level-1]!=0){
            f1=calculated[level-1];
        } else {
            f1 = climbStairs(level-1, calculated);
            calculated[level-1] = f1;
        }
        int f2;
        if (calculated[level-2]!=0) {
            f2 = calculated[level-2];
        } else {
            f2 = climbStairs(level-2, calculated);
            calculated[level-2] = f2;
        }
        return f1 + f2;
    }
}