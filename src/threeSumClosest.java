import java.util.*;

public class threeSumClosest {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;

        int closest = A[0] + A[1] + A[2];  // initial sum

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;

            while (l < r) {
                int sum = A[i] + A[l] + A[r];

                // Update closest sum
                if (Math.abs(sum - B) < Math.abs(closest - B)) {
                    closest = sum;
                }

                if (sum < B) {
                    l++;
                } else if (sum > B) {
                    r--;
                } else {
                    // exact match
                    return sum;
                }
            }
        }

        return closest;
    }
}
