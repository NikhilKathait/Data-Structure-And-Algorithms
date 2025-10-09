public class deleteOneElementFromArrayModular {
    public int solve(int[] A) {
        int N = A.length;
        int[] prefix = new int[N];
        int[] suffix = new int[N];

        // compute prefix GCD
        prefix[0] = A[0];
        for(int i = 1; i < N; i++) {
            prefix[i] = gcd(prefix[i - 1], A[i]);
        }

        // compute suffix GCD
        suffix[N - 1] = A[N - 1];
        for(int i = N - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i+1], A[i]);
        }

        int ans = 0;
        for (int i = 0; i<N; i++) {
            int g;
            if (i == 0) {
                g = suffix[1];  // remove first element
            }
            else if (i == N - 1) {
                g = prefix[N - 2];  // remove last element
            }
            else {
                g = gcd(prefix[i - 1], suffix[i + 1]);
            }

            ans = Math.max(ans, g);
        }
        return ans;
    }

    public int gcd(int A, int B) {
        if (B == 0) return A;

        return gcd(B, A % B);
    }
}
