public class specialSequencePairs {
    public Long solve(String A) {
        long countA = 0;
        long ans = 0;
        char[] C = A.toCharArray();

        for(int i=0; i<C.length; i++)
        {
            if(C[i] == 'A')
            {
                countA++;
            }
            else if(C[i] == 'G')
            {
                ans += countA;
            }
        }

        return ans;
    }
}
