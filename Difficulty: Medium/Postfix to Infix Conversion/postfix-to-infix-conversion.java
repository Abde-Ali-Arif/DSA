// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        int n = exp.length();
        Stack<String> st= new Stack<>();
        // StringBuilder ans = new StringBuilder();

        for(int i=0;i<n;i++){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else {
                String op1 = st.pop();
                String ans = "(" +st.pop() +ch + op1 + ")";
                st.push(ans);
            }
        }
        return st.pop();
        
    }
}
