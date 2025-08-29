import java.util.*;

public class leadersInAnArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = A.size();

        int maxFromRight = A.get(n - 1);
        leaders.add(maxFromRight);  // rightmost element is always a leader

        // Traverse from second last to first
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) > maxFromRight) {
                leaders.add(A.get(i));
                maxFromRight = A.get(i);
            }
        }

        // Reverse to restore original order
        Collections.reverse(leaders);
        return leaders;
    }
}
