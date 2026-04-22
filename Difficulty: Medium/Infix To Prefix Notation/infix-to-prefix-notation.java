class Solution {
    
    
    public int precedence(char ch){
        if(ch == '^')return 3;
        else if(ch == '*' || ch == '/')return 2;
        else if(ch == '+' || ch == '-')return 1;
        return 0;
    }
    
    public String infixToPrefix(String s) {
        int n = s.length();
        Stack<Character> st= new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }
            else {
                if(ch==')')st.push(ch);
                else if(ch == '(') {
                    while(!st.isEmpty() && st.peek() != ')'){
                        ans.append(st.pop());
                    }
                    st.pop(); // remove ')'
                }else{
                    if(st.isEmpty() || precedence(ch) > precedence(st.peek()))st.push(ch);
                    else {
                        while(!st.isEmpty() && (precedence(ch) < precedence(st.peek())||(precedence(ch) == precedence(st.peek()) && ch == '^'))){
                            ans.append(st.pop());
                        }
                        st.push(ch);
                    }
                }
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}