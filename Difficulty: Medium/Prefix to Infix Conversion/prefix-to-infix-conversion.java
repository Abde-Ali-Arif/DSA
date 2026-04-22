// User function Template for Java

class Solution {
    
    public static int precedence(char ch){
        if(ch == '^')return 3;
        else if(ch == '*' || ch == '/')return 2;
        else if(ch == '+' || ch == '-')return 1;
        return 0;
    }
    
    static String preToInfix(String pre_exp) {
        int n = pre_exp.length();
        Stack<String> st= new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i=n-1;i>=0;i--){
            char ch = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else if(!Character.isLetterOrDigit(ch)){
                    ans.append("(" + st.pop() + ch + st.pop() + ")");
                    // ans.append(st.pop());
                    // ans.append(ch);
                    // ans.append(st.pop()+")");
                    st.push(ans.toString());
                    ans.setLength(0);
            }
        }
        ans.append(st.pop());
        return ans.toString();
    }
}
