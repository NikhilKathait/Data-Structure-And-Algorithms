import java.util.*;

public class meetingRooms2 {
    public int solve(int A, int[][] B) {
        // sort based on start time
        Arrays.sort(B, (x,y) -> x[0] - y[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(B[0][1]);

        for (int i = 1; i<A; i++) {

            if (B[i][0] < minHeap.peek()) {
                minHeap.offer(B[i][1]);         // allocate a new room
            } else {
                minHeap.poll();                 // remove the finished meeting from minheap
                minHeap.offer(B[i][1]);         // Add the new meeting end time to the same room
            }
        }

        return minHeap.size();
    }
}
