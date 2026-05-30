class Solution {

    void printTriangle(int n) {
        StringBuilder ans= new StringBuilder();
        for(int i=1;i <= n;i++){
            for(int j=1;j<= n-i ;j++){
                ans.append(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                ans.append("*");
            }
            ans.append("\n");
        }
        System.out.print(ans.toString());
    
    }
}