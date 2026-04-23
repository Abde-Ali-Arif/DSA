// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        int n = pre_exp.length();
        Stack<String> st= new Stack<>();

        for(int i=n-1;i>=0;i--){
            char ch = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else {
                String ans = st.pop() + st.pop() +ch ;
                st.push(ans);
            }
        }
        return st.pop();
        
    }
}
