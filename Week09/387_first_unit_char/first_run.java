/**
这个题目可以用简单的hash来求解，时间复杂度是o(n)
*/
class Solution {
    public int firstUniqChar(String s) {
        int[]counter = new int[26];
        for(char c:s.toCharArray()) {
            counter[c-'a']++;
        }
        for(int i=0; i< s.length();i++) {
            if(counter[s.charAt(i)-'a']==1) {
                return i;
            }
        }
        return -1;
    }
}