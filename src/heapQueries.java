import java.util.*;

public class heapQueries {
    public int[] solve(int[][] A) {
        int N = A.length;
        int i = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        while (i < N) {
            int P = A[i][0];
            int Q = A[i][1];

            if (P == 2) {
                pq.add(Q);
            }
            else if (P == 1 && pq.size() > 0) {
                result.add(pq.remove());
            }
            else {
                result.add(-1);
            }

            i++;
        }

        int size = result.size();
        int[] ans = new int[size];

        for (int j = 0; j<size; j++) {
            ans[j] = result.get(j);
        }

        return ans;
    }
}
