import java.util.*;

public class bestTimeToBuySellStocks1 {
    public int maxProfit(final List<Integer> A) {
        if (A == null || A.size() == 0) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : A) {
            // keep track of minimum price so far
            if (price < minPrice) {
                minPrice = price;
            }
            // check profit if selling today
            else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}
