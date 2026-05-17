// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        int V= dist.length;
        
        // O(n^3)
        for(int via=0;via<V;via++){
            // via will figure another path if less path is present or not
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    // update if minimum weigth found and is not int max
                    if(dist[i][via] != (int)1e8 && dist[via][j] != (int)1e8)
                    dist[i][j]=Math.min(dist[i][j] , dist[i][via]+dist[via][j]);
                }
            }
        }
    }
}