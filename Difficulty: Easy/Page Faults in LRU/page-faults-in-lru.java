// User function Template for Java

class Solution {
    static int pageFaults(int N, int C, int pages[]) {
        int faults=0;
        // Queue<Integer> q= new LinkedList<>();
        ArrayList<Integer> q =new ArrayList<>();
        
        
        for(int i=0;i<N;i++){
            boolean found=false;
            for(int j=0;j<q.size();j++){
                if(q.get(j) == pages[i]){
                    found =true;
                    // page already present
                    // remove this from current index and add it to last
                    q.remove(j);
                    q.add(pages[i]);
                    
                }
            }
            if(!found){
                if(q.size() < C){
                    faults++;
                    q.add(pages[i]);
                }else{
                    faults++;
                    q.remove(0);
                    q.add(pages[i]);
                }
            } 
        }
        return faults;
    }
}