import java.util.*;

public class waveArray {
    public int[] wave(int[] A) {
        Arrays.sort(A); // sort the array

        // swap adjacent elements
        for (int i = 0; i + 1 < A.length; i += 2) {
            int temp = A[i];
            A[i] = A[i + 1];
            A[i + 1] = temp;
        }

        return A;
    }
}
