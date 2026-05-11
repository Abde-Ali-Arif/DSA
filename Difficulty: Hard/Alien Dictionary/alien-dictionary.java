class Solution {

    // dfs for topological sorting and cycle detection
    static boolean dfs(int u, int[][] graph, int[] vis, int[] rec, ArrayList<Character> ans) {

        // Mark the node as visited 
        //and part of the current recursion stack
        vis[u] = rec[u] = 1;

        for (int v = 0; v < 26; v++) {
            if (graph[u][v] == 1) {
                if (vis[v] == 0) {

                    // Recurse and check for cycle
                    if (!dfs(v, graph, vis, rec, ans))
                        return false;
                } else if (rec[v] == 1) {

                    // A cycle is detected if v is already 
                    //in the current recursion stack
                    return false;
                }
            }
        }

        // Add the character to the result after visiting all dependencies
        ans.add((char) ('a' + u));

        // Remove from recursion stack
        rec[u] = 0;
        return true;
    }

    // Function to find the correct order of characters in an alien dictionary
    static String findOrder(String[] words) {

        int[][] graph = new int[26][26];
        int[] exist = new int[26];
        int[] vis = new int[26];
        int[] rec = new int[26];
        ArrayList<Character> ans = new ArrayList<>();

        // Mark all characters that appear in the input
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exist[ch - 'a'] = 1;
            }
        }

        //Build the graph 
        for (int i = 0; i + 1 < words.length; i++) {
            String a = words[i], b = words[i + 1];
            int n = a.length(), m = b.length(), ind = 0;

            // Find the first different character between a and b
            while (ind < n && ind < m && a.charAt(ind) == b.charAt(ind))
                ind++;
            
            // if the order in dictionary is incorrect
            if (ind != n && ind == m)
                return "";

            if (ind < n && ind < m)
                graph[a.charAt(ind) - 'a'][b.charAt(ind) - 'a'] = 1;
        }

        for (int i = 0; i < 26; i++) {
            if (exist[i] == 1 && vis[i] == 0) {
                boolean x = dfs(i, graph, vis, rec, ans);

                // Return empty list if a cycle is found
                if (!x) return "";
            }
        }

        // Reverse to get the correct topological order
        Collections.reverse(ans);
        String res="";
        for(Character it:ans){
            res=res+it;
        }
        return res;
    }

}