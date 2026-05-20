class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)
                dist[i][j]=(int)1e8;
            }
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
           dist[u][v]= wt;
           dist[v][u]=wt;
        }
        // O(n^3)
        for(int via=0;via<n;via++){
            // via will figure another path if less path is present or not
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    // update if minimum weigth found and is not int max
                    if(dist[i][via] != (int)1e8 && dist[via][j] != (int)1e8)
                    dist[i][j]=Math.min(dist[i][j] , dist[i][via]+dist[via][j]);
                }
            }
        }

        // after flowd warshal is performed then do this to cnt smallest number of neighbours
        int cntcity=n, cityno=-1;
        for(int city =0;city<n;city++){
            int cnt=0;
            for(int i=0;i<n;i++){
                if(dist[city][i] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= cntcity){
                cntcity=cnt;
                cityno=city;
            }
        }
        return cityno;
    }
}