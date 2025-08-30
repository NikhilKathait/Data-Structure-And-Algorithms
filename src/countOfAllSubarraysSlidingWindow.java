public class countOfAllSubarraysSlidingWindow {
    public int solve(int[] A, int B) {
        int N = A.length;
        int start = 0, count = 0;
        long sum = 0;

        for(int end = 0; end < N; end++)
        {
            sum += A[end];

            // shrink window until sum < B
            while (sum >=B && start <= end)
            {
                sum -= A[start];
                start++;
            }

            // Now all subarrays ending at 'end' and starting from 'start..end' are valid
            count += end - start + 1;
        }

        return count;
    }
}
