import java.util.*;

public class totalSubarrays {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        int N = A.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i<N; i++)
        {
            ArrayList<Integer> subarray;
            for(int j = i; j<N; j++)
            {
                subarray = new ArrayList<>();
                for(int k = i; k<= j; k++)
                {
                    subarray.add(A.get(k));
                }
                result.add(subarray);
            }
        }
        return result;
    }
}
