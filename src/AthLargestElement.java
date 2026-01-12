import java.util.*;

public class AthLargestElement {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < B.size(); i++) {
            pq.offer(B.get(i));

            // keep only A largest elements
            if(pq.size() > A) {
                pq.poll();
            }

            if (pq.size() < A) {
                result.add(-1);
            } else {
                result.add(pq.peek());
            }
        }

        return result;
    }
}
