/**
国际站有个一圈解决问题的方法，这边也实现一下
*/
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer>map = new LinkedHashMap<>();
        Set<Character>set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                if(map.containsKey(s.charAt(i))) {
                    map.remove(s.charAt(i));
                }
            }else {
                map.put(s.charAt(i),i);
                set.add(s.charAt(i));
            }
        }
        return map.size()==0?-1:map.entrySet().iterator().next().getValue();
    }
}