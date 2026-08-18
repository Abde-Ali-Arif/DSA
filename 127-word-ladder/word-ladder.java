class Solution {

    class Pair{
        String word;
        int steps;
        Pair(String word,int steps){
            this.word = word;
            this.steps=steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>();
        Queue<Pair> q= new LinkedList<>();

        for(String s:wordList){
            set.add(s);
        }
        // if endword is not in the list no use of searching just explicitlly return
        if(!set.contains(endWord)) return 0;
        q.offer(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair p=q.poll();
            String word=p.word;
            int steps=p.steps;

            // if the end word reached then return steps
            if(word.equals(endWord))return steps;

            for(int i=0;i<word.length();i++){
                char[] replace=word.toCharArray();
                for(char ch='a';ch <= 'z';ch++){
                    replace[i]=ch;
                    String replacedWord=new String(replace);
                    if(set.contains(replacedWord)){
                        q.offer(new Pair(replacedWord,steps+1));
                        set.remove(replacedWord);
                    }
                }
            }
        }


        return 0;
    }
}