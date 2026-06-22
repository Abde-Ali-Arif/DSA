class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] hash= new int[5];
        // b -> 0
        // a -> 1
        // l -> 2
        // o -> 3
        // n -> 4

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(ch == 'b'){
                hash[0]++;
            }else if(ch == 'a'){
                hash[1]++;
            }else if(ch == 'l'){
                hash[2]++;
            }else if(ch == 'o'){
                hash[3]++;
            }else if(ch == 'n'){
                hash[4]++;
            }
        }
        int cnt=Integer.MAX_VALUE;
        for(int i=0;i<5;i++){
            if(i != 2 && i != 3){
                cnt=Math.min(hash[i],cnt);
            }else{
                cnt=Math.min(hash[i]/2,cnt);
            }
        }
        return cnt; 
    }
}