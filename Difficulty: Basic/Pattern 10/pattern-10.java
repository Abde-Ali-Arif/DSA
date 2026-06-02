class Solution {

    void printTriangle(int n) {
        for(int i=1;i<n*2;i++){
            if(i<=n){
                for(int j=1;j<=i;j++){
                    System.out.print("* ");
                }
            }else{
                for(int j=i;j<n*2;j++){
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}