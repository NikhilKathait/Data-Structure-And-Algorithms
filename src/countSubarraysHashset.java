import java.util.*;

public class countSubarraysHashset {
    public int solve(int[] A) {
        int n = A.length;
        int MOD = 1000000007;

        HashSet<Integer> set = new HashSet<>();

        long ans = 0;
        int left = 0;

        for (int right = 0; right < n; right ++) {

            // Remove until A[right] becomes unique
            while (set.contains(A[right])) {
                set.remove(A[left]);
                left++;
            }

            set.add(A[right]);

            // Count subarrays ending at right
            ans = (ans + (right - left + 1)) % MOD;
        }

        return (int) ans;
    }
}
