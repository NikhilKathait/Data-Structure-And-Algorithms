import java.util.*;

public class finishMaximumJobs {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();

        // store indices
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            idx.add(i);
        }

        // sort indices based on finish time
        Collections.sort(idx, (i,j) -> B.get(i) - B.get(j));

        // greedy selection
        int count = 1;
        int lastEnd = B.get(idx.get(0));

        for (int i = 1; i < n; i++) {
            int start = A.get(idx.get(i));
            int end = B.get(idx.get(i));

            if (start >= lastEnd) {
                count++;
                lastEnd = end;
            }
        }

        return count;
    }
}
