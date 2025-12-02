public class primeSum {
    public int[] primesum(int A) {
        boolean[] isPrime = new boolean[A+1];
        isPrime[0] = true;
        isPrime[1] = true;

        int limit = (int) Math.sqrt(A);
        for(int i = 2; i<= limit; i++) {
            if(!isPrime[i]) {
                for (int j = i * i; j <= A; j +=i) {
                    isPrime[j] = true;
                }
            }
        }

        // Find lexicographically the smallest pair: scan p from the smallest upward
        for (int p = 2; p <= A/2; p++) {
            if (!isPrime[p] && !isPrime[A-p]) {
                return new int[] {p, A-p};
            }
        }

        return new int[] {-1, -1};
    }
}
