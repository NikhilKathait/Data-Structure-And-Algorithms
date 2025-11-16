import java.util.*;

public class checkTwoBracketExpressions {
    public int solve(String A, String B) {
        int[] exp1 = evaluate(A);
        int[] exp2 = evaluate(B);

        for (int i = 0; i < 26; i++) {
            if (exp1[i] != exp2[i]) return 0;
        }
        return 1;
    }

    private int[] evaluate(String s) {
        int[] sign = new int[26];
        Stack<Integer> st = new Stack<>();

        int curr = 1;          // current sign
        st.push(1);            // global sign

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+') curr = 1;
            else if (c == '-') curr = -1;

            else if (c == '(') {
                st.push(st.peek() * curr);
                curr = 1;
            }

            else if (c == ')') {
                st.pop();
            }

            else if (c >= 'a' && c <= 'z') {
                sign[c - 'a'] = st.peek() * curr;
                curr = 1;
            }
        }
        return sign;
    }
}
