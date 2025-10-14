public class sortByColorCountSort {
    public int[] sortColors(int[] A) {
        int n = A.length;
        if (n == 0) return new int[0];

        int[] freq = new int[3];
        for (int num : A) {
            freq[num]++;
        }

        int[] result = new int[n];
        int idx = 0;
        for(int i = 0; i< 3; i++) {
            int count = freq[i];
            for (int j = 0; j < count; j++) {
                result[idx++] = i;
            }
        }

        return result;
    }
}
