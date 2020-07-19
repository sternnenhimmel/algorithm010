/**
dp方程可以写为f(n) = f(n-1) + f(n-2)，其中只有在n-1以及n能够组合成1-26的数时，f(n-2)才有效，不然记作0.
这个题有各种非法输入，导致非常恶心。。。
*/
class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0) {
            return 0;
        }
        if(s.startsWith("0")){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int[] count = new int[s.length()];
        count[0]=1;
        if(Integer.valueOf(s.substring(0,2))>26 && s.charAt(1)=='0') {
            return 0;
        }
        if(Integer.valueOf(s.substring(0,2))<=26 && s.charAt(1)!='0') {
            count[1]=2;
        }else{
            count[1]=1;
        }
        for(int i=2;i<s.length();i++) {
            if(s.charAt(i)=='0'&&s.charAt(i-1)=='0'){
                return 0;
            }
            if(Integer.valueOf(s.substring(i-1,i+1))>26 && s.charAt(i)=='0') {
                return 0;
            }
            if(Integer.valueOf(s.substring(i-1,i+1))<=26){
                if(s.charAt(i)=='0'){
                    count[i] = count[i-2];
                }else if(s.charAt(i-1)=='0') {
                    count[i] = count[i-1];
                }else{
                    count[i] = count[i-1] + count[i-2];
                }
            }else{
                count[i] = count[i-1];
            }
        }
        return count[s.length()-1];
    }
}