class Solution {

    void printTriangle(int n) {
        for(int i=1;i<=n;i++){
            // print spaces
            for(int j=i;j<n;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print((char)('A'+j));
            }
            for(int j=i-2;j>=0;j--){
                System.out.print((char)('A'+j));
            }
            System.out.println();
        }
    }
}