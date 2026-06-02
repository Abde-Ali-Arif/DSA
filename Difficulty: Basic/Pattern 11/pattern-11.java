class Solution {

    void printTriangle(int n) {
        boolean flag;
        for(int i=1;i<=n;i++){
            if(i%2!=0)flag=true;
            else flag=false;
            for(int j=1;j<=i;j++){
                if(flag)System.out.print(1+" ");
                else System.out.print(0+" ");
                flag=!flag;
            }
            System.out.println();
        }
    }
}