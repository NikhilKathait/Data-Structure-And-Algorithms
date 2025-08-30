public class minimumSwapsSlidingWindow {
    public int solve(int[] A, int B) {
        int N = A.length;

        // Count how many numbers are <= B
        int count = 0;
        for(int num : A)
        {
            if(num<=B)
                count++;
        }

        if (count == 0) return 0;

        // Number of elements greater than B in 1st window
        int greater = 0;
        for(int i = 0; i<count; i++)
        {
            if (A[i]>B)
                greater++;
        }

        int minSwaps = greater;

        // Sliding window across the array
        for(int i = count; i < N; i++)
        {
            // Remove leftmost element
            if(A[i - count] > B) greater--;

            // Add new element
            if(A[i] > B) greater++;

            minSwaps = Math.min(minSwaps, greater);
        }

        return minSwaps;
    }
}
