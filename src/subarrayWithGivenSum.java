public class subarrayWithGivenSum {
    public int[] solve(int[] A, int B) {
        int N = A.length;
        int start = 0;
        long sum = 0L;

        for (int end = 0; end < N; end++) {
            sum += A[end];

            // shrink window from left while sum > B and start <= end
            while (sum > B && start <= end) {
                sum -= A[start];
                start++;
            }

            if (sum == B) {
                // return subarray from start to end
                int len = end - start + 1;
                int[] res = new int[len];
                for (int i = 0; i < len; i++) {
                    res[i] = A[start + i];
                }
                return res;
            }
        }

        return new int[] {-1};
    }
}
