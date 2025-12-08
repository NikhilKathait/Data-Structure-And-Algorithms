public class maxContinuousSeriesof1s {
    public int[] maxone(int[] A, int B) {
        int n = A.length;
        int left = 0;
        int zeros = 0;

        int bestLeft = 0;
        int bestLen = 0;

        for (int right = 0; right < n; right++) {
            if (A[right] == 0) zeros++;

            // shrink from left while we have more than B zeros
            while (zeros > B) {
                if (A[left] == 0) zeros--;
                left++;
            }

            int currLen = right - left + 1;
            if (currLen > bestLen) {
                bestLen = currLen;
                bestLeft = left;
            }
        }

        // build result: indices from bestLeft to bestLeft + bestLen - 1
        if (bestLen == 0) return new int[] {0};

        int[] res = new int[bestLen];
        for (int i = 0; i < bestLen; i++) {
            res[i] = bestLeft + i;
        }

        return res;
    }
}
