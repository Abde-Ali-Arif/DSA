// User function Template for Java

class Solution {
    
    static String preToInfix(String pre_exp) {
        int n = pre_exp.length();
        Stack<String> st= new Stack<>();

        for(int i=n-1;i>=0;i--){
            char ch = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else if(!Character.isLetterOrDigit(ch)){
                    String ans = "(" + st.pop() + ch + st.pop() + ")";
                    st.push(ans);
            }
        }
        return st.pop();
    }
}
