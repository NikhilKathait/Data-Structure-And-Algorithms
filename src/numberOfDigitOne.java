public class numberOfDigitOne {
    public int solve(int A) {
        if (A <= 0) return 0;

        long p = 1;        // current digit position: 1, 10, 100...
        long count = 0;

        while (p <= A) {
            long left = A / (p * 10);
            long digit = (A / p) % 10;
            long right = A % p;

            if (digit == 0) {
                count += left * p;
            } else if (digit == 1) {
                count += left * p + (right + 1);
            } else { // digit > 1
                count += (left + 1) * p;
            }

            p *= 10;
        }

        return (int) count;
    }
}
