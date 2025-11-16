import java.util.*;

public class doubleCharacterTroubleStack {
    public String solve(String A) {
        Stack<Character> st = new Stack<>();

        for(char c : A.toCharArray()) {
            if (!st.isEmpty() && c == st.peek()) {
                st.pop();
            }
            else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);

        return sb.toString();
    }
}
