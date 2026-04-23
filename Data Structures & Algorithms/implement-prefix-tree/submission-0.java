class PrefixTree {
    TrieNode root;
    public class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            int place = ch - 'a';
            if(curr.children[place] == null){
                curr.children[place] = new TrieNode();
            }
            curr = curr.children[place];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            int place = ch - 'a';
            if(curr.children[place] == null){
                return false;                
            }
            curr = curr.children[place];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(Character ch : prefix.toCharArray()){
            int place = ch - 'a';
            if(curr.children[place] == null){
                return false;
            }
            curr = curr.children[place];
        }
        return true;
    }
}
