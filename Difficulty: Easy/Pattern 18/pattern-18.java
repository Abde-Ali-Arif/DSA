class Solution {

    void printTriangle(int n) {
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=i;j--){
                System.out.print((char)('A'+j)+" ");
            }
            System.out.println();
        }
    }
}