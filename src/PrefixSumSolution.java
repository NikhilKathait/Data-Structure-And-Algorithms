import java.util.*;

public class PrefixSumSolution {
    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int N = A.size();
        ArrayList<Long> pSum = new ArrayList<>();

        // For Prefix Sum
        pSum.add((long) A.get(0));

        for(int i=1; i<N; i++)
        {
            pSum.add(pSum.get(i-1) + A.get(i));
        }

        ArrayList<Long> result = new ArrayList<>();

        // To Process queries
        for(int i=0; i < B.size(); i++)
        {
            int L = B.get(i).get(0);
            int R = B.get(i).get(1);

            long sum;

            if (L == 0)
            {
                sum = pSum.get(R);
            }
            else
            {
                sum = pSum.get(R) - pSum.get(L - 1);
            }

            result.add(sum);
        }

        return result;
    }
}
