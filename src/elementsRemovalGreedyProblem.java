import java.util.*;

public class elementsRemovalGreedyProblem {
    public int solve(int[] A) {
        int N = A.length;
        if( N == 0) return 0;

        // Ascending sort
        Arrays.sort(A);

        int minCost = 0;
        int runningSum = 0;

        // Initial sum
        for (int num : A)
        {
            runningSum += num;
        }

        // Remove from Largest to Smallest
        for (int i = N-1; i >= 0; i--)
        {
            minCost += runningSum;          // Cost before removal
            runningSum -= A[i];             // runningSum after removal of element
        }

        return minCost;
    }
}
