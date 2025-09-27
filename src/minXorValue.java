import java.util.*;

public class minXorValue {
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int minXor = Integer.MAX_VALUE;
        int N = A.length;

        for(int i = 0; i<N-1; i++) {
            int xorVal = A[i] ^ A[i+1];
            minXor = Math.min(minXor, xorVal);
        }

        return minXor;
    }
}
