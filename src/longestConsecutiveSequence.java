import java.util.*;

public class longestConsecutiveSequence {
    public int longestConsecutive(final int[] A) {
        HashSet<Integer> hs = new HashSet<>();

        for (int ele : A) {
            hs.add(ele);
        }

        int ans = 0;

        for (int num : A) {

            if (hs.contains(num - 1)) {
                continue;
            } else {
                int nxt = num;

                while (hs.contains(nxt)) {
                    nxt += 1;
                }

                ans = Math.max(ans, nxt - num);
            }
        }

        return ans;
    }
}
