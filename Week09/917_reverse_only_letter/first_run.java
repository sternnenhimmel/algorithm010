class Solution {
    public String reverseOnlyLetters(String S) {
        char[]s = S.toCharArray();
        char[]s2 = new char[s.length];
        int i=0, j=s.length-1;
        while(i<s.length || j>=0){
            if(i<s.length&&!isLetter(s[i])) {
                s2[i]=s[i];
                i++;
            }else if(j>=0&&!isLetter(s[j])) {
                j--;
            }else{
                s2[i]=s[j];
                i++;
                j--;
            }
        }
        return new String(s2);
    }

    boolean isLetter(char c) {
        int i = c-'a';
        int j = c-'A';
        return (i>=0&&i<26)||(j>=0&&j<26);
    }
}