/**
直接复用输入的数据结构一层层往上求解
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size()<=0||triangle.get(0).size()<=0) {
            return 0;
        }
        for(int i= triangle.size()-2; i>=0; i--) {
            for(int j=0; j<triangle.get(i).size();j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}