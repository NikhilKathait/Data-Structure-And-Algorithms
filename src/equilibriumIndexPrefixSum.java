import java.util.*;

public class equilibriumIndexPrefixSum {
    public int solve(ArrayList<Integer> A) {
        long totalsum = 0;

        for(int num: A)
        {
            totalsum += num;
        }

        long leftsum = 0;
        for(int i = 0; i< A.size(); i++)
        {
            long rightsum = totalsum - leftsum - A.get(i);

            if (leftsum == rightsum)
            {
                return i;
            }
            leftsum += A.get(i);
        }

        return -1;
    }
}
