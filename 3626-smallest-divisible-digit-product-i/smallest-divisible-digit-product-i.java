class Solution {
    public int smallestNumber(int n, int t) {
        
        // start from n to infinity to chec for the smallest number

        while(true){
            int num=n;
            int multiply=1;
            while(num > 0){
                multiply *= num%10;
                num=num/10;
            }
            if(multiply % t == 0) return n;
            n++;
        }
    }
}