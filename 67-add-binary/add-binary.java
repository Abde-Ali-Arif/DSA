class Solution {
    public String addBinary(String a, String b) {
        int n1=a.length()-1;
        int n2=b.length()-1;
        int carry=0;
        StringBuilder ans = new StringBuilder();

        while(n1 != -1 || n2 != -1){
            int d1=0;
            int d2=0;
            if(n1 >= 0){
                d1=a.charAt(n1)-'0';
                n1--;
            }
            if(n2 >= 0){
                d2=b.charAt(n2)-'0';
                n2--;
            }
            carry += d1+d2;
            if(carry == 0)ans.append('0');
            else if(carry == 1){
                ans.append('1');
                carry=0;
            }
            else if(carry == 2){
                ans.append('0');
                carry = 1;
            }else{
                ans.append('1');
                carry=1;
            }
        }
        if(carry == 1)ans.append('1');
        return ans.reverse().toString();
    }
}