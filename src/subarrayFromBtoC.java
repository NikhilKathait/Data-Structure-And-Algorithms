import java.util.*;

public class subarrayFromBtoC {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B, int C) {
        ArrayList<Integer> subarray = new ArrayList<>();

        for(int i= B ; i<=C; i++)
        {
            subarray.add(A.get(i));
        }

        return subarray;
    }
}
