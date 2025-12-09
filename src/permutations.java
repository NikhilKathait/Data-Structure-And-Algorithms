import java.util.*;

public class permutations {
    public int[][] permute(int[] A) {
        List<int[]> results = new ArrayList<>();
        boolean[] used = new boolean[A.length];
        int[] current = new int[A.length];

        backtrack(A, used, current, 0, results);

        // convert List<int[]> to int[][]
        int[][] ans = new int[results.size()][A.length];
        for (int i = 0; i < results.size(); i++) {
            ans[i] = results.get(i);
        }

        return ans;
    }

    private void backtrack(int[] A, boolean[] used, int[] current, int idx, List<int[]> results) {
        if (idx == A.length) {
            // add a copy of current
            results.add(current.clone());
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current[idx] = A[i];

                backtrack(A, used, current, idx + 1, results);

                // undo
                used[i] = false;
                // current[idx] will be overwritten on next use, no need to clear
            }
        }
    }
}
