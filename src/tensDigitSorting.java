import java.util.*;

public class tensDigitSorting {
    public int[] solve(int[] A) {
        // Convert int[] to Integer[]
        Integer[] arr = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int tensA = (a / 10) % 10;
                int tensB = (b / 10) % 10;

                if (tensA != tensB) {
                    return tensA - tensB; // ascending tens digit
                } else {
                    return b - a;         // descending number if same tens digit
                }
            }
        });

        // Convert back to int[]
        for (int i = 0; i < A.length; i++) {
            A[i] = arr[i];
        }

        return A;
    }
}
