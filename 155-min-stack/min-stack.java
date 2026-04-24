class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        long v = val;
        if (st.isEmpty()) {
            st.push(v);
            min = v;
        } else {
            if (v < min) {
                st.push(2 * v - min); // safe now
                min = v;
            } else {
                st.push(v);
            }
        }
    }
    
    public void pop() {
        if (st.peek() < min) {
            min = 2 * min - st.peek();
        }
        st.pop();
    }
    
    public int top() {
        if (st.peek() < min) return (int) min;
        return (int)(long) st.peek();
    }
    
    public int getMin() {
        return (int) min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */