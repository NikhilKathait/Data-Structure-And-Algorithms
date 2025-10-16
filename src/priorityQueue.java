import java.util.*;

public class priorityQueue {
    public int[][] solve(int[][] A, int B) {
        Arrays.sort(A, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                long d1 = (long)p1[0] * p1[0] + (long)p1[1] * p1[1];
                long d2 = (long)p2[0] * p2[0] + (long)p2[1] * p2[1];
                return Long.compare(d1, d2);
            }
        });

        // Return the first B points
        return Arrays.copyOfRange(A, 0, B);
    }
}
