import java.util.*;

public class specialIndex {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        long[] preEven = new long[N];
        long[] preOdd = new long[N];

        // Build Prefix sums
        for(int i=0; i < N; i++)
        {
            if(i > 0)
            {
                preEven[i] = preEven[i-1];
                preOdd[i] = preOdd[i-1];
            }

            if(i%2 == 0)
            {
                preEven[i] += A.get(i);
            }
            else
            {
                preOdd[i] += A.get(i);
            }
        }

        long totalEven = preEven[N-1];
        long totalOdd = preOdd[N-1];
        int count = 0;

        // Check each index
        for(int i = 0; i < N; i++)
        {
            long leftEven = (i > 0) ? preEven[i - 1] : 0;
            long leftOdd = (i > 0) ? preOdd[i - 1] : 0;
            long rightEven = totalEven - preEven[i];
            long rightOdd = totalOdd - preOdd[i];

            // after removing i element (A[i]), right side flips parity
            if(leftEven + rightOdd == leftOdd + rightEven)
            {
                count++;
            }
        }

        return count;
    }
}
