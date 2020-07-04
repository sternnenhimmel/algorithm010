/**
还是用bfs来解题，并且在触及结果的那一圈停止循环
试了好多次，终于ac了，这个题目有点复杂
*/
class Solution {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //这个题本质上就是个图的广度遍历，因此，先把图中各个节点的联系构造出来
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        if (!wordSet.contains(beginWord)) {
            wordSet.add(beginWord);
        }
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String w : wordSet) {
            wordMap.put(w, new ArrayList<>());
        }
        int L = beginWord.length();
        char[] allChars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (String w : wordSet) {
            for (int i = 0; i < L; i++) {
                for (char c : allChars) {
                    String newW = w.substring(0, i) + c + w.substring(i + 1, L);
                    if (!newW.equals(w) && wordSet.contains(newW)) {
                        wordMap.get(w).add(newW);
                    }
                }
            }
        }
        //然后开始广度搜索
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(temp);
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> curr = queue.remove();
                List<String> neighers = wordMap.get(curr.get(curr.size() - 1));
                for (String word : neighers) {
                    if(!visited.contains(word)) {
                        if (word.equals(endWord)) {
                            curr.add(word);
                            res.add(curr);
                            break;
                        }
                        List<String> next = new ArrayList<>(curr);
                        next.add(word);
                        queue.add(next);
                        subVisited.add(word);
                    }
                }
            }
            visited.addAll(subVisited);
            if (!res.isEmpty()) {
                break;
            }
        }
        return res;
    }
}