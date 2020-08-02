/**
尝试自己写一遍这个位操作终极解法，非常快
*/
class Solution {
    int size;
    int count;
    public int totalNQueens(int n) {
        size = (1 << n) - 1;
        count = 0;
        solve(0,0,0);
        return count;
    }

    void solve(int lie, int pie, int na) {
        if(lie == size) {
            count++;
            return;
        }
        int blanks = size & ~(lie | pie | na);
        while(blanks!=0) {
            int p = blanks & -blanks;
            blanks -= p;
            solve(p|lie, (p|pie)<<1, (p|na)>>1);
        }
    }
}