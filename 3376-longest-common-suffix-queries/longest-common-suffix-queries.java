class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int idx = -1;
    }

    TrieNode root = new TrieNode();
    String[] wordsContainer;

    // choose better index according to rules
    int better(int a, int b) {
        if (a == -1) return b;
        if (b == -1) return a;

        int lenA = wordsContainer[a].length();
        int lenB = wordsContainer[b].length();

        if (lenA != lenB) {
            return lenA < lenB ? a : b;
        }

        return a < b ? a : b;
    }

    void insert(String word, int index) {
        TrieNode node = root;

        // update root
        node.idx = better(node.idx, index);

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            // store best index for this suffix path
            node.idx = better(node.idx, index);
        }
    }

    int search(String word) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        this.wordsContainer = wordsContainer;

        // build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}