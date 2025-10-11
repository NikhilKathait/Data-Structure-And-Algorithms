import java.util.*;

public class distinctNumbersInAWindowHashMap {
    public int[] dNums(int[] A, int B) {
        int N = A.length;

        if(B > N) {
            return new int[] {};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Build initial window of size B
        for (int i=0; i<B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        result.add(map.size()); // distinct count of first window

        // Slide the window
        for (int i = B; i<N; i++) {
            // Element going out of window
            int outgoing = A[i - B];
            map.put(outgoing, map.get(outgoing) - 1);

            if (map.get(outgoing) == 0) {
                map.remove(outgoing);
            }

            // Element coming into window
            int incoming = A[i];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);

            // Distinct count = map.size()
            result.add(map.size());
        }

        // Convert list to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
