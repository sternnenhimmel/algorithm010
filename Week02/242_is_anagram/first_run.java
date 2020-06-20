/**
用哈希表记录每个元素出现的次数，再进行比较，耗时o(n)，为了减少遍历次数，可以在遍历第二个字符串的时候减少第一个字符串的哈希表
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for(int i=0; i<s.length();i++) {
            table[s.charAt(i) - 'a'] ++;
        }
        for(int i=0; i<t.length();i++) {
            table[t.charAt(i) - 'a'] --;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}