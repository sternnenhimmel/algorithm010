/**
首先，按照老师推荐，自己写一遍用优先队列的解法
用一个最大堆，每次堆里面的数超过k个，就pop出来一个，这样最快，可以达到o(n*logk)
*/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length<=k){
            return arr;
        }
        if(k<=0) {
            return new int[0];
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        for (int i=k; i<arr.length; i++) {
            if(arr[i]<pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        int count = pq.size();
        int[] result = new int[count];
        for(int i=0;i<count;i++) {
            result[i] = pq.remove();
        }
        return result;
    }
}