public class maximumHeightOfStaircase {
    public int solve(int A) {
        int ans = 1;

        while (A >= ans) {
            A -= ans;
            ans++;
        }

        return ans - 1;
    }
}
