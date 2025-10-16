public class sort01s {
    public int[] sort01(int[] A) {
        int left = 0, right = A.length - 1;

        while (left < right) {
            if (A[left] == 0) {
                left++;
            } else if (A[right] == 1) {
                right--;
            } else {
                // swap 1 at left with 0 at right
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }

        return A;
    }
}
