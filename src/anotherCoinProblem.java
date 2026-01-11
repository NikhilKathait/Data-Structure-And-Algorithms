public class anotherCoinProblem {
    public int solve(int A) {
        int coins = 0;

        while (A > 0) {
            coins += A % 5;
            A /= 5;
        }

        return coins;
    }
}
