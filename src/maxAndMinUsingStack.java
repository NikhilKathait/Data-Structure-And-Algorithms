import java.util.*;

public class maxAndMinUsingStack {
    static final long MOD = 1000000007;

    public int solve(int[] A) {
        int n = A.length;

        long[] Lmax = new long[n], Rmax = new long[n];
        long[] Lmin = new long[n], Rmin = new long[n];

        // --- Previous Greater ---
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] <= A[i]) st.pop();
            Lmax[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        // --- Next Greater or Equal ---
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] < A[i]) st.pop();
            Rmax[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        // --- Previous Smaller ---
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) st.pop();
            Lmin[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        // --- Next Smaller or Equal ---
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] > A[i]) st.pop();
            Rmin[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        long maxSum = 0, minSum = 0;
        for (int i = 0; i < n; i++) {
            long maxContrib = (A[i] * Lmax[i] % MOD) * Rmax[i] % MOD;
            long minContrib = (A[i] * Lmin[i] % MOD) * Rmin[i] % MOD;

            maxSum = (maxSum + maxContrib) % MOD;
            minSum = (minSum + minContrib) % MOD;
        }

        return (int)((maxSum - minSum + MOD) % MOD);
    }
}
