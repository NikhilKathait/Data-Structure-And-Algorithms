import java.util.*;

public class arithmeticProgression {
    public int solve(int[] A) {
        int N = A.length;
        if(N == 0) return 0;

        Arrays.sort(A);

        int runningDifference = 0;
        int initialDifference = A[1] - A[0];

        for(int i = 2; i < N; i++)
        {
            runningDifference = A[i] - A[i-1];

            if(runningDifference != initialDifference)
            {
                return 0;
            }
        }

        return 1;
    }
}
