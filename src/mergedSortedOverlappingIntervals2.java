import java.util.*;

public class mergedSortedOverlappingIntervals2 {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int prevS = A.get(0).get(0);
        int prevE = A.get(0).get(1);

        for(int i = 1; i< A.size(); i++) {
            int currS = A.get(i).get(0);
            int currE = A.get(i).get(1);

            if(currS <= prevE) {

                // merge intervals
                prevE = Math.max(prevE, currE);
            } else {
                // add finished intervals
                ArrayList<Integer> merged = new ArrayList<>();
                merged.add(prevS);
                merged.add(prevE);
                ans.add(merged);

                // move to next
                prevS = currS;
                prevE = currE;
            }
        }

        // add the last interval
        ArrayList<Integer> last = new ArrayList<>();
        last.add(prevS);
        last.add(prevE);
        ans.add(last);

        return ans;
    }
}
