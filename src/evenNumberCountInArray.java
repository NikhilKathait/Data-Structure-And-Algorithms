import java.util.*;

public class evenNumberCountInArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int N = A.size();
        ArrayList<Integer> pEvenCount = new ArrayList<>();

        // Prefix count of evens
        for(int i=0; i<N; i++)
        {
            if(i == 0)
            {
                pEvenCount.add(A.get(0)%2 == 0 ? 1 : 0);
            }
            else{
                pEvenCount.add(pEvenCount.get(i - 1) + (A.get(i) % 2 == 0 ? 1 : 0));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i<B.size(); i++)
        {
            int count;
            int L = B.get(i).get(0);
            int R = B.get(i).get(1);

            if (L == 0)
            {
                count = pEvenCount.get(R);
            }
            else
            {
                count = pEvenCount.get(R) - pEvenCount.get(L - 1);
            }

            result.add(count);
        }

        return result;
    }
}
