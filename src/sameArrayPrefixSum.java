import java.util.*;

public class sameArrayPrefixSum {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        for(int i = 1; i<A.size(); i++)
        {
            A.set(i, A.get(i) + A.get(i - 1));
        }

        return A;
    }
}
