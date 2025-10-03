public class towerOfHanoiRecursion {
    // global index pointer for result array
    private int idx = 0;

    public int[][] towerOfHanoi(int A) {
        // total moves = 2^A - 1
        int M = (1 << A) - 1;
        int[][] result = new int[M][3];

        // move all A disks from rod 1 to rod 3 using rod 2
        solve(A, 1, 3, 2, result);
        return result;
    }

    private void solve(int n, int from, int to, int aux, int[][] result) {
        if (n == 0) return;

        // Step 1: move n-1 disks from "from" to "aux"
        solve(n-1, from, aux, to, result);

        // Step 2: move nth disk from "from" to "to"
        result[idx][0] = n;     // disk number
        result[idx][1] = from;  // source rod
        result[idx][2] = to;    // destination rod
        idx++;

        // Step 3: move n-1 disks from "aux" to "to"
        solve(n-1, aux, to, from, result);
    }
}
