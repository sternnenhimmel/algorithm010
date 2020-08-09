class Solution {
    public String reverseWords(String s) {
        String[]list = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.length;i++){
            sb.append(reverse(list[i]));
            if(i!=list.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    String reverse(String s) {
        char[]ss = s.toCharArray();
        int begin = 0, end = ss.length-1;
        while(begin<end) {
            char temp = ss[begin];
            ss[begin] = ss[end];
            ss[end]=temp;
            begin++;
            end--;
        }
        return new String(ss);
    }
}