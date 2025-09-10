public class reverseTheString {
    public String solve(String A) {
        int N = A.length();
        StringBuilder sb = new StringBuilder();

        int i = N - 1;
        while(i >= 0 && A.charAt(i) == ' ') {
            i--;
        }

        int count = 0;
        for(; i >= 0; i--)
        {
            char ch = A.charAt(i);
            if(ch != ' ') {
                sb.append(ch);
                count++;
            }
            else {
                if(count > 0) {
                    reverse(sb,sb.length() - count, sb.length() - 1);
                    count = 0;
                    sb.append(' ');
                }
            }
        }

        if(count > 0) {
            reverse(sb,sb.length() - count, sb.length() - 1);
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public void reverse(StringBuilder sb, int l, int r)
    {
        while(l < r) {
            char chl = sb.charAt(l);
            char chr = sb.charAt(r);

            sb.setCharAt(l, chr);
            sb.setCharAt(r, chl);
            l++;
            r--;
        }
    }
}
