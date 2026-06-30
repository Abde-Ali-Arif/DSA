class Solution {
    class Pair{
        int val;
        int row;
        int col;
        Pair(int v,int r,int c){
            val= v;
            row=r;
            col=c;
        }
    }
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        int n=mat.length;
        int m= mat[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{return a.val-b.val;});
        
        for(int i=0;i<n;i++){
            pq.offer(new Pair(mat[i][0],i,0));
        }
        
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int val=p.val;
            int row=p.row;
            int col=p.col;
            ans.add(val);
            if(col+1 < m)pq.offer(new Pair(mat[row][col+1],row,col+1));
        }
        return ans;
    }
}