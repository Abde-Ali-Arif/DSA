// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        int n = post_exp.length();
        Stack<String> st= new Stack<>();
        // StringBuilder ans = new StringBuilder();

        for(int i=0;i<n;i++){
            char ch = post_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else {
                String op1 = st.pop();
                String ans = ch + st.pop() + op1 ;
                st.push(ans);
            }
        }
        return st.pop();
        
    }
}
