import java.util.*;

public class prefixSumOddIndices {
    public ArrayList<Integer> sumOfOddIndexedElements(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int N = A.size();
        ArrayList<Integer> pSum = new ArrayList<>();

        // Only adding Odd indexed elements
        for(int i=0; i<N; i++)
        {
            if(i == 0)
            {
                pSum.add(0);
            }
            else if(i%2 == 1)
            {
                pSum.add(pSum.get(i-1) + A.get(i));
            }
            else
            {
                pSum.add(pSum.get(i-1));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // To Process queries
        for(int i=0; i < B.size(); i++)
        {
            int L = B.get(i).get(0);
            int R = B.get(i).get(1);

            int sum;

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
