class Solution {
    public long sumAndMultiply(int n) {
        long x =0;
        long sum=0;
        StringBuilder ans = new StringBuilder();
        while(n > 0){
            int digit=n%10;
            n=n/10;

            if(digit != 0){
                ans.append(digit);
                sum+=digit;
            }
        }
        if(ans.length() > 0)x=Integer.parseInt(ans.reverse().toString());
        return x*sum;
    }
}