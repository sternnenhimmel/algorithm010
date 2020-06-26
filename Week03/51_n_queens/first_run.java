/**
按照视频课的讲解，尝试用递归来实现
*/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>>res = new ArrayList<>();
        helper(res,new ArrayList<>(),n,0,new HashSet<>(),new HashSet<>(),new HashSet<>());
        return printRes(res, n);
    }

    void helper(List<List<Integer>>res, List<Integer>temp, int N, int curr, Set<Integer>pie, Set<Integer>na, Set<Integer>col) {
        if(curr == N){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<N; i++) {
            if(col.contains(i)||pie.contains(i+curr)||na.contains(i+N-curr)) {
                //go die
                continue;
            }
            pie.add(i+curr);
            na.add(i+N-curr);
            col.add(i);
            temp.add(i);
            helper(res,temp,N,curr+1,pie,na,col);
            pie.remove(i+curr);
            na.remove(i+N-curr);
            col.remove(i);
            temp.remove(temp.size()-1);
        }
    }

    List<List<String>>printRes(List<List<Integer>>list, int N){
        List<List<String>> res = new ArrayList<>();
        for(List<Integer>sub : list){
            List<String>strs = new ArrayList<>();
            for(Integer i:sub){
                String str = "";
                for(int j=0;j<i;j++){
                    str+=".";
                }
                str+="Q";
                for(int j=i+1;j<N;j++){
                    str+=".";
                }
                strs.add(str);
            }
            res.add(strs);
        }
        return res;
    }
}