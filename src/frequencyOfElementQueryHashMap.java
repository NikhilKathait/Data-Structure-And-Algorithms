import java.util.*;

public class frequencyOfElementQueryHashMap {
    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Adding each element frequency in HashMap
        for(int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // An answer array of same length as B
        int[] ans = new int[B.length];

        // Fill answer array using frequency map
        for(int i = 0; i< B.length; i++) {
            ans[i] = map.getOrDefault(B[i], 0);
        }

        return ans;
    }
}
