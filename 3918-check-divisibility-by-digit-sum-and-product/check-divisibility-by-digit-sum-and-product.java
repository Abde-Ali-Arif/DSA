class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int num=n;
        while(num > 0){
            int digit=num%10;
            num=num/10;
            sum +=digit;
            prod *=digit;
        }
        num=sum+prod;
        // if(n%num == 0)return true;
        // return false
        return n%num == 0; 
    }
}