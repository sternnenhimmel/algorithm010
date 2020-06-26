/**
这个应该就是典型的递归求解了
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        if( digits.length()==0 ) {
            return new ArrayList<>();
        }
        Map<Character, String>map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String>res = new ArrayList<>();
        letterCombinations(res, digits, 0, "",map);
        return res;
    }
    void letterCombinations(List<String>res, String digits, int current, String temp,Map<Character, String>map){
        if(current==digits.length()){
            res.add(temp);
            return;
        }
        char[] thisLevelChars = map.get(digits.charAt(current)).toCharArray();
        for(int i=0;i<thisLevelChars.length;i++){
            letterCombinations(res, digits, current+1, temp+thisLevelChars[i],map);
        }
    }
}