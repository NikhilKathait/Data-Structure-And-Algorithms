public class isAlphanumericString {
    public int solve(char[] A) {
        if(A == null || A.length == 0) return 0;

        int N = A.length;

        for(int i = 0; i<N; i++)
        {
            char ch = A[i];

            if(!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <='9'))
            {
                return 0;
            }
        }

        return 1;
    }
}
