public class singleNumber2 {
    public int singleNumber(final int[] A) {
        int ans = 0;
        int N = A.length;

        for(int i = 0; i < 32; i++) {
            int count = 0;

            for(int j = 0; j<N; j++) {
                if((A[j] & (1<<i)) != 0)
                    count++;
            }

            if(count %3 != 0) {
                ans = ans | (1<<i);
            }
        }

        return ans;
    }
}
