/**
开始没什么思路，看了一部分评论后发现，这个题目关键在于要设计一种表示方法，使得字母异位词能有相同的表示，然后放在hashMap里面去计数即可.
这里使用对于每个字母出现的次数进行计数的方法，这样处理每个词需要的时间是o(m)，处理所有的词就需要o(m*n)的时间，外部再进行遍历则需要o(n)，所以时间复杂度是o(m*n)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) {
            return new ArrayList<>();
        }
        Map<String,List<String>>map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            String transformed = transform(strs[i]);
            if(!map.containsKey(transformed)) {
                map.put(transformed, new ArrayList<>());
            }
            map.get(transformed).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    private String transform(String s) {
        int[] count = new int[26];
        for (int i=0; i< s.length(); i++) {
            count[s.charAt(i)-'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<26;i++) {
            if(count[i]!=0) {
                sb.append('a'+i)
                .append(String.valueOf(count[i]));
            }
        }
        return sb.toString();
    }
}