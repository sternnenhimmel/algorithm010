/**
尝试用广度优先遍历解题
*/
class Solution {
    List<String>gennList = new ArrayList<>();
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)||start==null||end==null) {
            return 0;
        }
        gennList.add("A");
        gennList.add("C");
        gennList.add("G");
        gennList.add("T");
        Set<String>bankSet = new HashSet<>(Arrays.asList(bank));
        Queue<String>queue = new LinkedList<>();
        queue.add(start);
        Set<String>visited = new HashSet<>();
        visited.add(start);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String str = queue.remove();
                visited.add(str);
                List<String>mutations = generateMutations(str, visited, bankSet);
                for(int j=0; j<mutations.size(); j++) {
                    String curr = mutations.get(j);
                    if(curr.equals(end)) {
                        return level;
                    } else {
                        queue.add(curr);
                    }
                }
            }
        }
        return -1;
    }

    List<String>generateMutations(String str, Set<String>visited, Set<String> bank){
        List<String>res = new ArrayList<>();
        for(int i=0;i<str.length();i++) {
            String prefix, suffix;
                if(i==0){
                    prefix = "";
                }else{
                    prefix = str.substring(0,i);
                }
                if(i==str.length()-1){
                    suffix="";
                }else{
                    suffix=str.substring(i+1, str.length());
                }
            for(int j=0;j<gennList.size();j++){
                if(!Objects.equals(str.substring(i,i+1),gennList.get(j))) {
                    String newStr = prefix + gennList.get(j) + suffix;
                    if(bank.contains(newStr)&&!visited.contains(newStr)) {
                        res.add(newStr);
                    }
                }
            }
        }
        return res;
    }
}