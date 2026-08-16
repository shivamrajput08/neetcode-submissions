class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd ;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;
    public WordDictionary() {
   root = new TrieNode();
    }

    public void addWord(String word) {
    TrieNode curr = root;
    for(char ch : word.toCharArray()){
        int idx = ch -'a';
        if(curr.children[idx] == null){
            curr.children[idx] = new TrieNode();
        }
        curr = curr.children[idx];
    }
    curr.isEnd = true;
    }

    public boolean search(String word) {
         return dfs(word , 0 , root);
    }
    private boolean dfs(String word , int i , TrieNode node){
        if(node == null) return false;

        if(i == word.length()) return node.isEnd;
        char ch = word.charAt(i);

        if(ch == '.'){
            for(TrieNode child : node.children){
                if(child != null && dfs(word , i+1 , child)) return true;  
            }
            return false;
        }
        else{
            int idx = ch - 'a';
            return dfs(word , i+1 , node.children[idx]);
        }
    }
}
