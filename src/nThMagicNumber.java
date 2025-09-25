public class nThMagicNumber {
    public int solve(int A) {
        int ans = 0;
        int power = 1;

        while (A > 0) {
            power *= 5;
            if((A & 1) == 1) {
                ans += power;
            }

            A >>= 1;
        }

        return ans;
    }
}
