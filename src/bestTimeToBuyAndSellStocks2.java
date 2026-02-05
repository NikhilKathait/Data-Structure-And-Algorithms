public class bestTimeToBuyAndSellStocks2 {
    public int maxProfit(final int[] A) {
        int n = A.length;
        int profit = 0;

        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                profit += A[i] - A[i - 1];
            }
        }

        return profit;
    }
}
