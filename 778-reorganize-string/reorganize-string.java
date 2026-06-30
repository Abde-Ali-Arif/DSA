class Solution {
    class Pair{
        int freq;
        char ch;
        Pair(int f,char c){
            freq=f;
            ch=c;
        }
    }
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        // Pair -> {freq,char}
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->{return b.freq-a.freq;});
        for(int i=0;i<26;i++){
            if(hash[i] != 0) pq.offer(new Pair(hash[i],(char)('a'+i)));
        }

        StringBuilder ans = new StringBuilder();

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int freq= p.freq;
            char ch=p.ch;
            if(ans.length() == 0 || ans.charAt(ans.length()-1) != ch){
                ans.append(ch);
                if(freq >= 2)pq.offer(new Pair(freq-1,ch));
            }else{
                // prev character is same as current popped so cannot place ch of p pair
                if(pq.isEmpty())return "";
                Pair p2=pq.poll();
                ans.append(p2.ch);
                if(p2.freq >= 2)pq.offer(new Pair(p2.freq-1,p2.ch));
                pq.offer(new Pair(freq,ch)); // pushing p pair as it is
            }
        }
        return ans.toString();
    }
}