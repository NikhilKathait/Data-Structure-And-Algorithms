import java.util.*;

public class kPlacesApartSortNearlySortedArray {
    public int[] solve(int[] A, int B) {
        int[] result = new int[A.length];
        int idx = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i<= B; i++) {
            minHeap.offer(A[i]);
        }

        result[idx++] = minHeap.poll();

        for (int i = B+1; i < A.length; i++) {
            minHeap.offer(A[i]);
            result[idx++] = minHeap.poll();
        }

        while (!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll();
        }

        return result;
    }
}
