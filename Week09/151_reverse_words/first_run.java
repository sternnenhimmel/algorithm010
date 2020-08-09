
class Solution {
    public String reverseWords(String s) {
        String[]list = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=list.length-1;i>=0;i--){
            if(list[i].length()==0) {
                continue;
            }
            sb.append(list[i]);
            if(i!=0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}