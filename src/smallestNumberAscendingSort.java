public class smallestNumberAscendingSort {
    public int[] smallestNumber(int[] A) {
        int n = A.length;
        if (n == 0) return new int[0];

        // Frequency array of length 10 for digits 0 to 9
        int [] freq = new int[10];
        for (int num : A) {
            freq[num]++;
        }

        // Build result array in ascending order
        int[] result = new int[n];
        int idx = 0;
        for( int i = 0; i < 10; i++) {
            int count = freq[i];
            for (int k = 0; k < count; k++) {
                result[idx++] = i;
            }
        }

        return result;
    }
}
