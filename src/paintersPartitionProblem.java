public class paintersPartitionProblem {
    public int paint(int A, int B, int[] C) {
        int n = C.length;
        long max = Integer.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (C[i] > max) {
                max = C[i];
            }

            sum += C[i];
        }

        long low = max * (long) B;
        long high = sum * (long) B;

        long ans = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            int painters = minPainter(mid, B, C);

            if (painters <= A) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return (int) ((ans % 10000003 + 10000003) % 10000003);
    }

    private int minPainter(long T, int B, int[] C) {
        int painters = 1;
        long timeLeft = T;
        int n = C.length;

        for (int i = 0; i < n; i++) {
            long boardTime = (long) C[i] * B;

            if (boardTime > T) return Integer.MAX_VALUE;

            else if (boardTime <= timeLeft) {
                timeLeft -= boardTime;
            }
            else {
                painters++;
                timeLeft = T - (long) boardTime;
            }
        }

        return painters;
    }
}
