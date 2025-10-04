public class isMagicNumber {
    public int solve(int A) {
        // Base case: if A is single digit
        if (A < 10) {
            return (A == 1) ? 1 : 0;
        }

        // Calculate sum of digits
        int sum = 0;
        while (A > 0) {
            sum += A % 10;
            A /= 10;
        }

        // Recursive call with the sum
        return solve(sum);
    }
}
