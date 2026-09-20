class Solution {

    private void operation(String s,Stack<Integer> st){
        int y=st.pop();
        int x=st.pop();
        if(s.equals("+"))st.push(x+y);
        else if(s.equals("-")) st.push(x-y);
        else if(s.equals("*"))st.push(x*y);
        else if(s.equals("/")) st.push(x/y);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st= new Stack<>();
        
        for(String s:tokens){
            if(s.matches("[+*/-]")){
                operation(s,st);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}