/**
还有一种双向队列的解法，可以明显降低搜索空间，效果也比较好
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> combs = new HashMap<>();
        int L = beginWord.length();
        for(String word: wordList) {
            for(int i=0; i<L; i++) {
                char[]wordChar = word.toCharArray();
                wordChar[i] = '*';
                String newWord = new String(wordChar);
                if (combs.get(newWord) == null) {
                    combs.put(newWord, new ArrayList<>());
                }
                combs.get(newWord).add(word);
            }
        }
        Queue<String> Q1 = new LinkedList<>();
        Queue<String> Q2 = new LinkedList<>();
        Q1.add(beginWord);
        Q2.add(endWord);
        Set<String>V1 = new HashSet<>();
        Set<String>V2 = new HashSet<>();
        V1.add(beginWord);
        V2.add(endWord);
        int level1 = 0;
        int level2 = 0;
        while(!Q1.isEmpty()&&!Q2.isEmpty()) {
            level1++;
            level2++;
            boolean hit = visitNode(Q1,V1,V2, combs);
            if(hit) {
                return level1+level2;
            }
            hit = visitNode(Q2,V2,V1, combs);
            if(hit) {
                return level1+level2+1;
            }
        }
        return 0;
    }

    boolean visitNode(Queue<String>queue, Set<String>visited, Set<String>others, Map<String, List<String>> combs) {
        int size = queue.size();
        for(int i=0; i<size; i++) {
            String word = queue.remove();
            for(int j=0;j<word.length();j++) {
                char[]wordChar = word.toCharArray();
                wordChar[j] = '*';
                String comb = new String(wordChar);
                List<String>bankWords = combs.get(comb);
                if(bankWords!=null) {
                    for(String bw:bankWords){
                        if(others.contains(bw)) {
                            return true;
                        }
                        if(!visited.contains(bw)) {
                            visited.add(bw);
                            queue.add(bw);
                        }
                    }
                }
            }
        }
        return false;
    }
}