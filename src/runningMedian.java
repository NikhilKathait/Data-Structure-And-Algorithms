import java.util.*;

public class runningMedian {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxi = new PriorityQueue<>(Collections.reverseOrder());  // max heap
        PriorityQueue<Integer> mini = new PriorityQueue<>();       // min heap
        ArrayList<Integer> result = new ArrayList<>();

        // first element
        maxi.add(A.get(0));
        result.add(maxi.peek());

        for (int i = 1; i < A.size(); i++) {
            int x = A.get(i);

            // Add element to correct heap
            if (x <= maxi.peek()) {
                maxi.add(x);
            } else {
                mini.add(x);
            }

            // balance max heap and min heap
            int diff = Math.abs(maxi.size() - mini.size());
            if (diff > 1)
                balance(maxi, mini);

            // get median
            if (maxi.size() >=  mini.size())
                result.add(maxi.peek());
            else
                result.add(mini.peek());
        }

        return result;
    }

    public void balance(PriorityQueue<Integer> maxi, PriorityQueue<Integer> mini) {
        if (maxi.size() > mini.size()) {
            mini.add(maxi.poll());
        } else {
            maxi.add(mini.poll());
        }
    }
}
