public class simpleReverse {
    public String solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        int N = A.length();

        int l = 0, r = N - 1;

        while(l < r) {
            char chl = sb.charAt(l);
            char chr = sb.charAt(r);

            sb.setCharAt(l, chr);
            sb.setCharAt(r, chl);
            l++;
            r--;
        }

        return sb.toString();
    }
}
