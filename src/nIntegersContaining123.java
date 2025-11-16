import java.util.*;

public class nIntegersContaining123 {
    public int[] solve(int A) {
        int[] result = new int[A];
        Queue<Integer> q = new LinkedList<>();

        // Start with base numbers
        q.add(1);
        q.add(2);
        q.add(3);

        int idx = 0;

        while (idx < A) {
            int curr = q.poll();
            result[idx++] = curr;

            // Generate next numbers
            q.add(curr * 10 + 1);
            q.add(curr * 10 + 2);
            q.add(curr * 10 + 3);
        }

        return result;
    }
}
