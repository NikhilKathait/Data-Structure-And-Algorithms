import java.util.*;

public class subArrayWith0SumHashSet {
    public int solve(int[] A) {
        long sum = 0L;
        HashSet<Long> set = new HashSet<>();

        for (int num : A) {
            sum += num;

            // if prefix sum is zero (subarray 0..i) OR we've seen this prefix before
            if (sum == 0L || set.contains(sum)) {
                return 1;
            }
            set.add(sum);
        }

        return 0;
    }
}
