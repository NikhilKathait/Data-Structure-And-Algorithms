public class printAto1Recursion {
    public void solve(int A) {
        printNumbers(1, A);
        System.out.println();
    }

    private void printNumbers(int N, int A) {
        if(N == A + 1) return;

        printNumbers(N + 1, A);
        System.out.print(N + " ");
    }

    public void decreasingNumber(int A) {
        if (A == 0) {
            System.out.println(); // final newline after done
            return;
        }

        System.out.print(A + " ");   // print current number
        decreasingNumber(A - 1);
    }
}
