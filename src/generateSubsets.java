import java.util.*;

public class generateSubsets {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // code here
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        generate(A, ans, curr, 0);

        return ans;
    }

    private void generate(ArrayList<Integer> A,  ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, int idx) {

        // Add the current subset
        ans.add(new ArrayList<>(curr));

        // Generate all next subsets
        for (int i = idx; i < A.size(); i++) {
            curr.add(A.get(i));                  // choose
            generate(A, ans, curr, i + 1);       // recurse
            curr.remove(curr.size() - 1);        // un-choose
        }
    }
}
