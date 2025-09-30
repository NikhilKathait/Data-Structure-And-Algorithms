public class print1toARecursion {
    public void solve(int A) {
        printNumbers(A);
        System.out.println();
    }

    private void printNumbers(int A) {
        if(A == 0) return;

        printNumbers(A - 1);
        System.out.print(A + " ");
    }
}
