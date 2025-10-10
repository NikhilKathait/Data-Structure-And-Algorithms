import java.util.*;

public class firstRepeatingElementHashMap {
    public int solve(int[] A) {
        int N = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Count occurrences
        for(int num : A) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Find first element with count > 1
        for (int num : A) {
            if (hm.get(num) > 1) {
                return num;
            }
        }
        return -1;
    }
}
