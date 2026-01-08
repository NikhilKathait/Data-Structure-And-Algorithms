import java.util.*;

public class mishaAndCandiesHeap {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : A) {
            pq.add(val);
        }

        int totalCandiesEaten = 0;

        while (!pq.isEmpty()) {
            int minCandies = pq.remove();

            // If Misha dislikes the box, stop
            if (minCandies > B) {
                break;
            }

            // Eating logic
            int eaten = minCandies / 2;
            int remaining = minCandies - eaten;
            totalCandiesEaten += eaten;

            // Put remaining candies into next minimum box
            if (!pq.isEmpty()) {
                int nextMin = pq.remove();
                pq.add(nextMin + remaining);
            }
        }

        return totalCandiesEaten;
    }
}
