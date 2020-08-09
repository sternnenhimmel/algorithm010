class Solution {
    public String reverseStr(String s, int k) {
        int total =s.length();
        int frags = total/(2*k);
        if(total%(2*k)!=0) {
            frags++;
        }
        char[]ss = s.toCharArray();
        for(int i=0;i <frags;i++) {
            reverse(ss, i*2*k, Math.min(ss.length-1, i*2*k+k-1));
        }
        return new String(ss);
    }
    void reverse(char[]ss, int begin, int end) {
        while(begin<end) {
            char temp = ss[begin];
            ss[begin] = ss[end];
            ss[end]=temp;
            begin++;
            end--;
        }
    }
}