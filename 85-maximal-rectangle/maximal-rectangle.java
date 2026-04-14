class Solution {
    public int largestRectangle(int[] arr){
        int max=0;
        Stack<Integer> st= new Stack<>();

        for(int i=0;i<arr.length;i++){
            // compute area only if the current histogram is smaller
            // else continue to add it in stack
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int ind = st.pop();
                int nse =i;
                int pse=(st.isEmpty())? -1:st.peek();
                max=Math.max(max,arr[ind]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
                int ind = st.pop();
                int nse =arr.length;
                int pse=(st.isEmpty())? -1:st.peek();
                max=Math.max(max,arr[ind]*(nse-pse-1));
            }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int maxArea = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1')height[j]++;
                else height[j]=0;
            }
            maxArea=Math.max(maxArea,largestRectangle(height));
        }
        return maxArea;
    }

}