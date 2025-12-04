public class pairWithGivenSumII {
    public int solve(int[] A, int B) {
        final long MOD = 1000000007L;
        int N = A.length;
        int start = 0, end = N - 1;
        long ans = 0;

        while (start < end) {
            long sum = (long)A[start] + (long)A[end];

            if (sum < B)
                start++;
            else if (sum > B)
                end--;
            else {
                if (A[start] == A[end]) {
                    long count = end - start + 1;
                    ans = (ans + ((count * (count - 1) / 2) % MOD)) % MOD;
                    break;
                }

                long leftCount = 1;
                long rightCount = 1;

                while (start + 1 < end && A[start] == A[start + 1]) {
                    leftCount++;
                    start++;
                }

                while (end - 1 > start && A[end] == A[end - 1]) {
                    rightCount++;
                    end--;
                }

                ans = (ans + (leftCount * rightCount) % MOD) % MOD;
                start++;
                end--;
            }
        }

        return (int)ans;
    }
}
