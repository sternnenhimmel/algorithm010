/**
这个题目定义子问题比较难，可以把某一个位置上的某一个jump_size能否到达最终的位置作为一个子问题加以记录，以此简化搜索空间
*/
class Solution {
    public boolean canCross(int[] stones) {
        int[][]memo = new int[stones.length][stones.length];
        return canCross(stones,0,0,memo)==1;
    }
    int canCross(int[]stones, int pos, int jumpSize, int[][]memo) {
        if(memo[pos][jumpSize]!=0) {
            return memo[pos][jumpSize];
        }
        for(int i=pos+1;i<stones.length;i++) {
            int gap = stones[i] - stones[pos];
            if(jumpSize-1<= gap && gap <=jumpSize+1) {
                if(canCross(stones,i,gap,memo)==1) {
                    memo[pos][gap]=1;
                    memo[pos][jumpSize]=1;
                    return 1;
                }
            }
            if(gap>=jumpSize+1) {
                break;
            }
        }
        memo[pos][jumpSize] = pos == stones.length-1?1:-1;
        return memo[pos][jumpSize];
    }


}