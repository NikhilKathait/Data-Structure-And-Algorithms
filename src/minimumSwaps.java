public class minimumSwaps {
    public int solve(int[] A, int B) {
        int N = A.length;
        int count = 0;

        // count how many elements are <= B
        for(int num : A) {
            if(num <= B) count++;
        }

        if(count == 0) return 0;

        // First window
        int curr = 0;
        for(int i = 0; i<count; i++) {
            if(A[i] <= B) curr++;
        }

        int maxValid = curr;

        // Slide the window
        for(int i = count; i < N; i++) {
            if(A[i] <= B) curr++;           // New element
            if(A[i-count] <= B) curr--;
            maxValid = Math.max(maxValid, curr);
        }

        // Minimum swaps = total good elements - max good in a window
        return count - maxValid;
    }
}
