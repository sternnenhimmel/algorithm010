class Trie {
    int R = 26;
    class TrieNode{
        TrieNode[]ch = new TrieNode[26];
        boolean isEnd = false;
    }
    TrieNode root;


    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i)-'a';
            if(current.ch[idx]==null) {
                current.ch[idx] = new TrieNode();
            }
            current = current.ch[idx];
        }
        current.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current =searchPrefix(word);
        return current!=null && current.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current =searchPrefix(prefix);
        return current!=null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode current = root;
        for(int i=0; i<word.length();i++) {
            int idx = word.charAt(i)-'a';
            current = current.ch[idx];
            if(current==null){
                break;
            }
        }
        return current;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */