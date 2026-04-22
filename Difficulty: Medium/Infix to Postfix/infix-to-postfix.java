class Solution {
    public static int precedence(char ch){
        if(ch == '^')return 3;
        else if(ch == '*' || ch == '/')return 2;
        else if(ch == '+' || ch == '-')return 1;
        return 0;
    }
    public static String infixToPostfix(String s) {
        int n = s.length();
        Stack<Character> st= new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.pop());
                }
                st.pop(); // remove '('
            }
            else {
                while(!st.isEmpty() && (precedence(st.peek()) > precedence(ch) || (precedence(st.peek()) == precedence(ch) && ch != '^'))){
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
}