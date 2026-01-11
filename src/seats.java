import java.util.*;

public class seats {
    public int seats(String A) {
        int MOD = 10000003;
        int n = A.length();

        // store positions of people
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == 'x') {
                pos.add(i);
            }
        }

        int k = pos.size();
        if (k == 0 || k == 1) return 0;

        // median index
        int mid = k/2;
        int medianPos = pos.get(mid);

        long jumps = 0;
        int target = medianPos - mid;

        for (int i = 0; i < k; i++) {
            jumps += Math.abs(pos.get(i) - (target + i));
            jumps %= MOD;
        }

        return (int)jumps;
    }
}
