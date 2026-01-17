public class maxProductDPIterative {
    public int maxProduct(final int[] A) {
        int maxSoFar = A[0];
        int minSoFar = A[0];
        int result = A[0];

        for (int i = 1; i < A.length; i++) {
            int curr = A[i];

            // If current number is negative, swap max and min
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}
