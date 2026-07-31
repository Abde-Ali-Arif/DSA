class Solution {
    public int celebrity(int mat[][]) {
        int n= mat.length;
        
        ArrayList<Integer> store = new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean celebrity=true;
            for(int j=0;j<n;j++){
                if(i == j) continue;
                if(mat[i][j] == 1){
                   // cannot be celebrity in any situation
                   celebrity = false;
                   break;
                }
            }
            if(celebrity)store.add(i);
        }
        
        // check if stored elements are celerbity or not
        for(int cel:store){
            boolean celebrity = true;
            // iterate in its column to see wheter everyone knows him or not
            for(int i=0;i<n;i++){
                if(mat[i][cel] == 0){
                    celebrity = false;
                    break;
                }
            }
            if(celebrity) return cel;
        }
        
        return -1;
    }
}