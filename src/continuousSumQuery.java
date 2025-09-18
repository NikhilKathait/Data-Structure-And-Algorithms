public class continuousSumQuery {
    public int[] solve(int A, int[][] B) {
        int Q = B.length;

        int[] psum = new int[A];

        for(int i = 0; i<Q; i++)
        {
            int L = B[i][0] - 1;
            int R = B[i][1] - 1;
            int P = B[i][2];

            psum[L] += P;

            if(R+1 < A) {
                psum[R+1] -= P;
            }
        }

        for(int i = 1; i< A; i++) {
            psum[i] += psum[i-1];
        }

        return psum;
    }
}
