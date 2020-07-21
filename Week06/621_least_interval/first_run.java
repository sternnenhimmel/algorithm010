/**
这个题可以看成是每一轮最多执行n+1个任务，出现次数最多的那种任务的个数就是需要跑的最少圈数
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]cnt = new int[26];
        for(char a:tasks) {
            cnt[a-'A']++;
        }
        Arrays.sort(cnt);
        int idleSlot = (n+1) * (cnt[25]-1);
        int leftSlot = idleSlot;
        for(int i=25; i>=0; i--) {
            if(cnt[i]==cnt[25]) {
                leftSlot++;
                idleSlot++;
            }
            leftSlot-=cnt[i];
        }
        return leftSlot>0?idleSlot:tasks.length;
    }
}