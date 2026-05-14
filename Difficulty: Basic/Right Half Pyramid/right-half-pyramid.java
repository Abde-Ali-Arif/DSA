class Solution {
    void printRightHalfPyramid(int n) {
        StringBuilder ans= new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                // System.out.print("* ");
                ans.append("* ");
            }
            // System.out.println();
            ans.append("\n");
        }
        System.out.print(ans.toString());
    }
}