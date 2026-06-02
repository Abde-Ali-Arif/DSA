class Solution {

    void printTriangle(int n) {
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                System.out.print((char)('A'+j));
            }
            System.out.println();
        }
    }
}