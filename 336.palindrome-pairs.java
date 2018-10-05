/*
 * [336] Palindrome Pairs
 *
 * https://leetcode.com/problems/palindrome-pairs/description/
 *
 * algorithms
 * Hard (28.11%)
 * Total Accepted:    47.7K
 * Total Submissions: 169.8K
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]] 
 * Explanation: The palindromes are
 * ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]] 
 * Explanation: The palindromes are ["battab","tabbat"]
 * 
 * 
 * 
 * 
 */
class Solution {
    class Trie {
        Trie[] next;
        List<Integer> list;
        int wordIdx;
        public Trie() {
            next = new Trie[26];
            list = new ArrayList<>();
            wordIdx = -1;
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        Trie root = new Trie();
        for(int i = 0; i < words.length; i++) {
            addTrie(words, i, root);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            searchTrie(words, i, root, list);
        }
        return list;
    }
    public void addTrie(String[] words, int index, Trie root) {
        String s = words[index];
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, i, s.length() - 1)) {
                root.list.add(index);
            }
            int idx = s.charAt(i) - 'a';
            if(root.next[idx] == null) {
                root.next[idx] = new Trie();
            }
            root = root.next[idx];
        }
        root.wordIdx = index;
    }
    public void searchTrie(String[] words, int index, Trie root, List<List<Integer>> list){
        String s = words[index];
        if(root.wordIdx >= 0 && isPalindrome(s, 0, s.length() - 1) && root.wordIdx != index) {
            List<Integer> tmp = Arrays.asList(root.wordIdx, index);  
            list.add(tmp);
        }
        for(int i = s.length() - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if(root.next[idx] == null) {
                return;
            }
            root = root.next[idx];
            if(root.wordIdx >= 0 && isPalindrome(s, 0, i - 1) && root.wordIdx != index) {
                List<Integer> tmp = Arrays.asList(root.wordIdx, index);  
                list.add(tmp);
            }
        }
        for(int i: root.list) {
            if(i != index) {
                List<Integer> tmp = Arrays.asList(i, index);  
                list.add(tmp);
            }
        }
    }
    public boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
