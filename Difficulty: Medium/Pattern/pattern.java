class Solution {
    public void printDiamond(int n) {
        for(int i=1;i<=2*n;i++){
            if(i<=n){
                for(int j=1;j<=n-i;j++){
                System.out.print(" ");
                }
                for(int j=1;j<=i;j++){
                System.out.print("* ");
                }
                System.out.println();
            }else{
                for(int j=1;j<=n-(2*n-i+1);j++){
                System.out.print(" ");
                }
                for(int j=1;j<=2*n-i+1;j++){
                System.out.print("* ");
                }
                System.out.println();
            }
        }
    }
}