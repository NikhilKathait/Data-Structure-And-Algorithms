import java.util.*;

public class checkPairSum {
    public int solve(int A, int[] B) {
        int N = B.length;
        if (N < 2) return 0;

        Arrays.sort(B);

        int start = 0, end = N - 1;

        while (start < end) {
            long sum = (long)B[start] + (long)B[end];

            if (sum == A)
                return 1;
            else if (sum > A)
                end--;
            else
                start++;
        }

        return 0;
    }
}
