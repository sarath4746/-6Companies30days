class Solution {
    
    static ArrayList<ArrayList<String>> displayContacts(int n, String[] contacts, String prefix) {
        
        //code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Trie trie = new Trie();
    
        for(String contact : contacts){
            trie.insert(contact);
        }
        
        for(int i = 1; i <= prefix.length(); i++){
            ArrayList<String> words = trie.getWords(prefix.substring(0, i));
            Collections.sort(words);
            words = new ArrayList<>(new LinkedHashSet<>(words));
            
            if(words.isEmpty()){
                words.add("0");
            }
            result.add(words);
        }
        return result;
    }

    static class TrieNode {
        
        TrieNode[] children = new TrieNode[26];
        
        boolean isEndOfWord;
        ArrayList<String> words;
        
        TrieNode(){
            words = new ArrayList<>();
        }
    }

    static class Trie{
        
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        void insert(String word){
            
            TrieNode currentNode = root;
            
            for(int i = 0; i < word.length(); i++) {
                
                char ch = word.charAt(i);
                
                if(currentNode.children[ch - 'a'] == null){
                    currentNode.children[ch - 'a'] = new TrieNode();
                }
                
                currentNode = currentNode.children[ch - 'a'];
                currentNode.words.add(word);
            }
            
            currentNode.isEndOfWord = true;
        }
        
        ArrayList<String> getWords(String prefix) {
            
            TrieNode currentNode = root;
            
            for(int i = 0; i < prefix.length(); i++) {
                
                char ch = prefix.charAt(i);
                if(currentNode.children[ch - 'a'] == null) return new ArrayList<>();
                currentNode = currentNode.children[ch - 'a'];
            }
            return currentNode.words;
        }
    }

}