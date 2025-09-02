import java.util.*;

public class kthSmallestElement {
    public int kthsmallest(final int[] A, int B) {
        Arrays.sort(A);
        int count = 0;
        for(int i = 0; i< A.length; i++)
        {
            if (i+1 == B)
            {
                return A[i];
            }
        }

        return -1;
    }
}
