public class findGoodDays {
    public int solve(int A) {
        int count = 0;
        while(A > 0) {
            if((A & 1) == 1) {
                count++;
            }

            A >>= 1;
        }

        return count;
    }
}
