public class goodSubarrays {
    public int solve(int[] A, int B) {
        int N = A.length;
        int count = 0;

        // Build prefix sum
        int[] prefix = new int[N+1];
        for(int i = 0; i < N; i++)
        {
            prefix[i+1] = prefix[i] + A[i];
        }

        // Check all subarrays
        for(int i = 0; i<N; i++)
        {
            for(int j=i; j<N; j++)
            {
                int length = j - i + 1;
                int sum = prefix[j + 1] - prefix[i];

                if((length % 2 == 0 && sum < B) ||
                        (length % 2 == 1 && sum > B))
                {
                    count++;
                }
            }
        }

        return count;
    }
}
