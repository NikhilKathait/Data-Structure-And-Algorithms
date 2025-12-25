import java.util.*;

public class colourfulNumberHashSet {
    public int colorful(int A) {
        ArrayList<Integer> digits = new ArrayList<>();

        // Extract digits
        while (A > 0) {
            digits.add(A % 10);
            A /= 10;
        }

        // Reverse to maintain original order
        Collections.reverse(digits);

        HashSet<Long> seen = new HashSet<>();

        int n = digits.size();

        // Generate all consecutive subsequences
        for (int i = 0; i < n; i++) {
            long product = 1;
            for (int j = i; j < n; j++) {
                product *= digits.get(j);

                // If product already exists, not colorful
                if (seen.contains(product)) {
                    return 0;
                }

                seen.add(product);
            }
        }

        return 1;
    }
}
