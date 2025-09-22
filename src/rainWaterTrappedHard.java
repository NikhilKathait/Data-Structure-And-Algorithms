public class rainWaterTrappedHard {
    public int trap(final int[] A) {
        int N = A.length;
        int trapped = 0;
        int max = 0, maxidx = 0;

        for(int i = 0; i < N; i++) {
            if(A[i] > max) {
                max = A[i];
                maxidx = i;
            }
        }

        int rmax = max;
        int lmax = A[0];

        for(int i=0; i < maxidx; i++) {
            lmax = Math.max(lmax, A[i]);

            trapped += Math.min(lmax, rmax) - A[i];
        }

        lmax = max;
        rmax = A[N-1];

        for(int i = N-1; i > maxidx; i--) {
            rmax = Math.max(rmax, A[i]);

            trapped += Math.min(lmax, rmax) - A[i];
        }

        return trapped;
    }
}
