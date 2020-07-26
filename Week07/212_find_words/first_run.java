/**
课程中的题目，试着实现一下
*/
class Solution {
    int[]dx = new int[]{1,-1,0,0};
    int[]dy = new int[]{0,0,1,-1};
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length==0||board[0].length==0||words.length==0) {
            return new ArrayList<>();
        }
        Trie trie = new Trie();
        for(String word:words) {
            trie.insert(word);
        }
        Set<String>res = new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length;j++) {
                boolean[][]visited = new boolean[board.length][board[0].length];
                dfs(res,board,i,j,trie,visited);
            }
        }
        return new ArrayList<>(res);
    }
    void dfs(Set<String>res, char[][]board, int i, int j, Trie curr, boolean[][]visited) {
        int m = board.length;
        int n = board[0].length;
        if(i<0||j<0||i>=m||j>=n) {
            return;
        }
        if(visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int idx = board[i][j]-'a';
        if(curr.ch[idx]==null) {
            visited[i][j]=false;
            return;
        }
        if(curr.ch[idx].isEnd) {
            res.add(curr.ch[idx].val);
        }
        for(int k=0;k<4;k++) {
            dfs(res, board, i+dx[k],j+dy[k],curr.ch[idx],visited);
        }
        visited[i][j] = false;
    }
}

class Trie {
    Trie[]ch = new Trie[26];
    boolean isEnd = false;
    String val;

    public void insert (String word) {
        Trie curr = this;
        for(char c:word.toCharArray()) {
            int idx = c-'a';
            if (curr.ch[idx]==null) {
                curr.ch[idx] = new Trie();
            }
            curr = curr.ch[idx];
        }
        curr.isEnd = true;
        curr.val = word;
    }
}