import java.util.*;

public class SubsetSumEqualToK {
    public int SubsetSum(ArrayList<Integer> A, int B) {
        // empty subset has sum = 0
        if (B == 0) return 1;

        boolean[] found = new boolean[1];
        backtrack(A, 0, 0L, B, new ArrayList<>(), found);
        return found[0] ? 1 : 0;
    }

    private void backtrack(ArrayList<Integer> A, int index, long currSum,
                           long target, ArrayList<Integer> subset, boolean[] found) {
        if (found[0]) return;   // Early exit if solution found

        // If we processed all elements
        if (index == A.size()) {
            if (currSum == target) {
                found[0] = true;
            }
            return;
        }

        // Include current element
        subset.add(A.get(index));
        backtrack(A, index + 1, currSum + A.get(index), target, subset, found);
        subset.remove(subset.size() - 1);  // backtrack

        if (found[0]) return;

        // Exclude current element
        backtrack(A, index + 1, currSum, target, subset, found);
    }
}
