import java.util.*;

public class printPathsInStaircase {
    public ArrayList<ArrayList<Integer>> WaysToClimb(int A) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        distinctWays(A, path, ans, 0);

        return ans;
    }

    private void distinctWays(int A, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans, int idx) {
        if (idx == A) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (idx > A) {
            return;
        }

        // Choice 1: take 1 step
        path.add(1);
        distinctWays(A, path, ans, idx + 1);
        path.remove(path.size() - 1);

        // Choice 2: take 2 steps
        path.add(2);
        distinctWays(A, path, ans, idx + 2);
        path.remove(path.size() - 1);
    }
}
