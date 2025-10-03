public class printArrayUsingRecursion {
    public void PrintArray(int[] A) {
        printIdx(A, 0);
        System.out.println();
    }

    public void printIdx(int[] A, int i) {
        int N = A.length;
        if(i == N) return;

        System.out.print(A[i] + " ");
        printIdx(A, i+1);
    }
}
