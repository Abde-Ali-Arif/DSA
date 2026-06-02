class Solution {
    public void printSquare(int n) {

        int size = 2 * n - 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                int top = i;
                int left = j;
                int bottom = size - 1 - i;
                int right = size - 1 - j;

                int minDist = Math.min(Math.min(top, bottom),Math.min(left, right));

                System.out.print((n - minDist) + " ");
            }
            System.out.println();
        }
    }
}