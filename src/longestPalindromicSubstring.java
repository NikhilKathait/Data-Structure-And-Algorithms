public class longestPalindromicSubstring {
    public String longestPalindrome(String A) {
        int N = A.length();
        if(N <= 1) return A;

        int start = 0, maxLen = 1;

        for(int i = 0; i < N; i++)
        {
            int len1 = expand(A, i, i); // for odd indices
            int len2 = expand(A, i, i+1); // for even indices

            int len = Math.max(len1, len2);

            if(len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2 ;
            }
        }

        return A.substring(start, start + maxLen);
    }

    public int expand(String A, int si, int ei) {
        int N = A.length();

        while(si >= 0 && ei < N && A.charAt(si) == A.charAt(ei)) {
            si--;
            ei++;
        }

        return ei-si-1;
    }
}
