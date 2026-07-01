class Solution {
    class Pair{
        int freq;
        char ch;
        Pair(int f,char c){
            freq=f;
            ch=c;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];

        for(int i=0;i<tasks.length;i++){
            hash[tasks[i]-'A']++;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{return b.freq-a.freq;});
        HashMap<Character,Integer> nextSeat= new HashMap<>();

        for(int i=0;i<26;i++){
            if(hash[i] != 0){
                nextSeat.put((char)('A'+i),1);
                pq.offer(new Pair(hash[i],(char)('A'+i)));
            }
        }
        int seat=1;
        while(!pq.isEmpty()){
            ArrayList<Pair> store= new ArrayList<>();
            while(!pq.isEmpty()){
                Pair p=pq.poll();
                if(nextSeat.get(p.ch) <= seat){
                    // place
                    nextSeat.put(p.ch,seat+1+n);
                    if(p.freq > 1)pq.offer(new Pair(p.freq-1,p.ch));
                    break;
                }
                else{
                    // not able to place so keep in side and try to find another char from PQ
                    store.add(p);
                }
            }
            seat++;
            while(store.size() > 0){
                pq.offer(store.remove(store.size()-1));
            }
        }
        return seat-1;
    }
}