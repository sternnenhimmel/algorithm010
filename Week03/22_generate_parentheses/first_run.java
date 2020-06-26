/**
根据课程学到的方法，用递归模版，来手动实现一遍
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(0,0,2*n,res,"");
        return res;
    }

    private void generateParenthesis(int left, int right, int n, List<String>res, String curr){
        if (left + right == n) {
            res.add(curr);
            return;
        }
        if(left < n/2){
            generateParenthesis(left+1,right, n, res, curr+"(");
        }
        if (right < left) {
            generateParenthesis(left, right+1, n, res, curr+")");
        }
    }
}