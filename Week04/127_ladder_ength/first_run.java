/**
这个看起来和基因的题很像，这里先尝试用bfs来解
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        char[] allAl = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Queue<String> queue = new LinkedList<>();
        Set<String>visited = new HashSet<>();
        Set<String>bank = new HashSet<>(wordList);
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String word = queue.remove();
                List<String> generated = generateWordList(visited, bank, word, allAl);
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

    List<String> generateWordList(Set<String>visited, Set<String>bank, String word, char[] allAl) {
        List<String>res = new ArrayList<>();
        for(int i=0;i<word.length();i++) {
            for(char c : allAl) {
                if(!Objects.equals(word.charAt(i), c)) {
                    char[]wordChar = word.toCharArray();
                    wordChar[i] = c;
                    String newWord = new String(wordChar);
                    if(bank.contains(newWord)&&!visited.contains(newWord)) {
                        visited.add(newWord);
                        res.add(newWord);
                    }
                }
            }
        }
        return res;
    }
}