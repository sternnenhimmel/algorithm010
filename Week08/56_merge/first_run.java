/**
把区间按第一个值进行排序，然后再从前往后过一遍，把能合并的进行合并
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]>merged = new ArrayList<>();
        int pivot = 0;
        int max = intervals[0][1];
        for(int i=1; i<intervals.length;i++) {
            if(intervals[i][0]<=max) {
                max = Math.max(intervals[i][1],max);
                continue;
            }else {
                merged.add(new int[]{intervals[pivot][0],max});
                pivot = i;
                max = intervals[i][1];
            }
        }
        merged.add(new int[]{intervals[pivot][0],Math.max(intervals[intervals.length-1][1],max)});
        int[][]res = new int[merged.size()][2];
        for(int i=0;i<merged.size();i++){
            res[i][0] = merged.get(i)[0];
            res[i][1] = merged.get(i)[1];
        }
        return res;
    }
}