public class countOfDivisors {
    public int[] solve(int[] A) {
        if (A == null || A.length == 0) return new int[0];

        int N = A.length;
        int maxA = 0;

        for (int val : A) {
            if (val > maxA)
                maxA = val;
        }

        int[] divCount = new int[maxA + 1];

        for (int d = 1 ; d <= maxA; d++) {
            for (int m = d; m <= maxA; m += d) {
                divCount[m]++;
            }
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = divCount[A[i]];
        }

        return result;
    }
}
