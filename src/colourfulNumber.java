import java.util.*;

public class colourfulNumber {
    public int colorful(int A) {
        String num = String.valueOf(A);
        Set<Integer> products = new HashSet<>();

        for(int i = 0; i < num.length(); i++) {
            int product = 1;
            for(int j = i; j < num.length(); j++) {
                product *= (num.charAt(j) - '0');

                if(products.contains(product)) {
                    return 0;
                }

                products.add(product);
            }
        }

        return 1;
    }
}
