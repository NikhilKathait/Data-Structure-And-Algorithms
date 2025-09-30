public class decreasingIncreasingRecursion {
    // Static variable to track the top-level call
    private static boolean firstCall = true;

    public void DecThenInc(int A) {
        int N = 0;

        if(A == 0) {
            return;
        }

        if (firstCall) {
            N = A;
            firstCall = false;
        }
        System.out.print(A + " "); // print decreasing part
        DecThenInc(A - 1);          // recursive call
        System.out.print(A + " "); // print increasing part

        // If we are back at the top-level call, print newline
        if (A == N) {
            System.out.println();
            firstCall = true; // reset for future calls
        }
    }
}
