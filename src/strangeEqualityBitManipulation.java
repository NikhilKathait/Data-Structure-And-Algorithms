public class strangeEqualityBitManipulation {
    public int solve(int A) {
        // Find msb (power of 2 just greater than A)
        int msb = 1;
        while (msb <= A) {
            msb <<= 1;
        }

        // Gretest number smaller than A with no common set bits
        int X = (msb - 1) ^ A;

        // Smallest number greater than A with no common set bits
        int Y = msb;

        return X ^ Y;
    }
}
