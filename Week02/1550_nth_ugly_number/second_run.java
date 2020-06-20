/**
然后用最小堆实现，即维护一个最小堆，每次取出最小的值，如果不重复，则认为是有效的
*/
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long>pq = new PriorityQueue<>();
        pq.add(2L);
        pq.add(3L);
        pq.add(5L);
        Set<Long>set = new HashSet<>();
        long num=1L;
        long tmp=0L;
        for(int i =1;i<n;i++){
            num=pq.poll();
            tmp=2*num;
            if(!set.contains(tmp)){
                set.add(tmp);
                pq.add(tmp);
            }
            tmp=3*num;
            if(!set.contains(tmp)){
                set.add(tmp);
                pq.add(tmp);
            }
            tmp=5*num;
            if(!set.contains(tmp)){
                set.add(tmp);
                pq.add(tmp);
            }
        }
        return (int)num;
    }
}
