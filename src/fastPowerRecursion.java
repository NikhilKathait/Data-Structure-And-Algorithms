public class fastPowerRecursion {
    public long power(int A, int B) {
        // base case
        if(B == 0) { return 1;}

        long half = power(A, B/2); // recursive call

        if (B%2 == 0) {
            return half*half;       // even power
        } else {
            return A*half*half;     // odd power
        }
    }
}
