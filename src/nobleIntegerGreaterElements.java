import java.util.*;

public class nobleIntegerGreaterElements {
    public class Solution {
        public int solve(int[] A) {
            Arrays.sort(A);
            int N = A.length;

            for(int i = 0; i<N; i++)
            {
                // Skip duplicates
                if( i < N - 1 && A[i] == A[i+1])
                    continue;

                // count for greater Integers
                int greaterIntegers = N - (i +1);

                if(A[i] == greaterIntegers)
                {
                    return 1;
                }
            }

            return -1;
        }
    }
}
