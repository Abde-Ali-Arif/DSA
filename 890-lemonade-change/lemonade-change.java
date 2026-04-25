class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Store (Notes , Frequency)
        // int [] map= new int [2];
        int five=0,ten=0;
        for(int i =0 ; i< bills.length;i++){
            if(bills[i] == 5){
                five++;
            }else if (bills[i] == 10){
                // change of 5 given
                if(five >= 1)five--;
                else return false;
                ten++;
            }else{
                if(ten >= 1 && five >= 1){
                    // change of 10 and 5 given
                    ten--;
                    five--;
                }else if (five >= 3){
                    // change of 5 given (3 notes)
                    five -= 3;
                }else return false;
            }
        }
        return true;
    }
}