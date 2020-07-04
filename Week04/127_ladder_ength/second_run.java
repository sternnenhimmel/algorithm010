/**
观看题解以后，发现制作词汇表可以用一点空间来缩短遍历的次数，效果比较好，这里尝试一下
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
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String>visited = new HashSet<>();
        visited.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for(int i =0; i< size; i++) {
                String word = queue.remove();
                List<String> generated = generateWordList(visited, combs, word);
                for(String one : generated) {
                    if(one.equals(endWord)) {
                        return level+1;
                    }
                    queue.add(one);
                }
            }
        }
        return 0;
    }

    List<String> generateWordList(Set<String>visited, Map<String, List<String>> combs, String word) {
        List<String>res = new ArrayList<>();
        for(int i=0;i<word.length();i++) {
            char[]wordChar = word.toCharArray();
            wordChar[i] = '*';
            String comb = new String(wordChar);
            List<String>bankWords = combs.get(comb);
            if(bankWords!=null) {
                for(String bw:bankWords){
                    if(!visited.contains(bw)) {
                        visited.add(bw);
                        res.add(bw);
                    }
                }
            }
        }
        return res;
    }
}