class Solution {

    void printTriangle(int n) {
        // upper half
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("  ");
            }
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // lower half
        for(int i=n;i>0;i--){
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("  ");
            }
            for(int j=i;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}