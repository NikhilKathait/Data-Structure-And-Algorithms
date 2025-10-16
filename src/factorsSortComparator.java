import java.util.*;

public class factorsSortComparator {
    public int[] solve(int[] A) {
        // Convert int[] to Integer[]
        Integer[] arr = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }

        // Custom sort by number of factors, then by value
        Arrays.sort(arr, new Comparator<Integer> () {
            public int compare (Integer a, Integer b) {
                int fa = factors(a);
                int fb = factors(b);

                if (fa < fb) return -1;
                else if (fa > fb) return 1;
                else {
                    if (a < b) return -1;
                    else if (a > b) return 1;
                    else return 0;
                }
            }
        });

        // Convert back to int[]
        for (int i = 0; i < A.length; i++) {
            A[i] = arr[i];
        }

        return A;
    }

    private int factors(int N) {
        int count = 0;
        for (int i = 1; i*i <= N; i++) {
            if (N % i == 0) {
                if (i * i == N)
                    count += 1; // perfect square
                else
                    count += 2; // pair of factors
            }
        }

        return count;
    }
}
