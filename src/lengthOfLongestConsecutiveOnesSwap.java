public class lengthOfLongestConsecutiveOnesSwap {
    public int solve(String A) {
        int N = A.length();
        int countOfOnes = 0;

        for(int i = 0; i < N; i++) {
            char ch = A.charAt(i);
            if(ch == '1') {
                countOfOnes++;
            }
        }

        if(countOfOnes == 0) {return 0;}
        else if (countOfOnes == N) { return N;}

        int ans = 0;

        for(int i = 0; i < N; i++)
        {
            char ch = A.charAt(i);
            if(ch == '0') {
                int l = 0;
                for(int j = i - 1; j >= 0; j--) {
                    if(A.charAt(j) == '1') {l++;}
                    else {break;}
                }
                int r = 0;
                for(int j = i + 1; j < N; j++) {
                    if(A.charAt(j) == '1') {r++;}
                    else {break;}
                }

                if(countOfOnes > (l+r))
                    ans = Math.max(ans, l+r+1);
                else
                    ans = Math.max(ans, l+r);
            }
        }

        return ans;
    }
}
