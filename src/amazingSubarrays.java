public class amazingSubarrays {
    public int solve(String A) {
        if(A == null || A.length() == 0) return 0;

        int N = A.length();
        long count = 0;
        for(int i = 0; i < N; i++)
        {
            char ch = A.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                count += (N-i);
            }
        }

        return (int)(count % 10003) ;
    }
}
