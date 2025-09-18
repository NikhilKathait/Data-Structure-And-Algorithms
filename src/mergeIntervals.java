import java.util.*;

public class mergeIntervals {
    public int[][] insert(int[][] A, int[] B) {
        List<int[]> ans = new ArrayList<>();
        int n = A.length;
        int i = 0;

        // Add all intervals before B
        while (i < n  && A[i][1] < B[0]) {
            ans.add(A[i]);
            i++;
        }

        // Merge overlapping intervals with before
        while(i<n && A[i][0] <= B[1]) {
            B[0] = Math.min(B[0], A[i][0]);
            B[1] = Math.max(B[1], A[i][1]);
            i++;
        }

        ans.add(B);

        // Add remaining intervals
        while (i < n) {
            ans.add(A[i]);
            i++;
        }

        // Convert list to array
        return ans.toArray(new int[ans.size()][]);
    }
}
