/**
当前的题目还可以看成是递归。即3对括号可以看成是一对括号基础上插入2对括号，2对括号又可以看成是一对括号基础上再插入一对括号，以此类推
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>>res = new ArrayList<>(n+1);
        List<String>dp0 = new ArrayList<>();
        dp0.add("");
        res.add(dp0);
        for(int i=1; i<n+1; i++) {
            List<String> curr = new ArrayList<>();
            for(int j=0; j< i;j++) {
                List<String>str1 = res.get(j);
                List<String>str2 = res.get(i-j-1);
                for(String s1:str1){
                    for(String s2:str2){
                        curr.add("("+s1+")"+s2);
                    }
                }
            }
            res.add(curr);
        }
        return res.get(n);
    }
}