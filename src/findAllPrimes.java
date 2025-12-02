public class findAllPrimes {
    public int[] solve(int A) {
        boolean isPrime[] = new boolean[A+1];
        isPrime[0] = true;
        isPrime[1] = true;

        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i] == false) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        int size = 0;

        for (int i = 2; i <= A; i++) {
            if (isPrime[i] == false)
                size++;
        }

        int result[] = new int[size];
        int index = 0;

        for (int i = 2; i <= A; i++) {
            if (isPrime[i] == false) {
                result[index++] = i;
            }
        }

        return result;
    }
}
