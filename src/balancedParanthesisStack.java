import java.util.*;

public class balancedParanthesisStack {
    public int solve(String A) {
        Stack<Character> st = new Stack<>();

        for (char c : A.toCharArray()) {

            // If opening bracket then push
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            // If closing bracket then check top
            else if (c == ')' || c == '}' || c == ']') {

                // If stack empty then no matching open bracket
                if (st.isEmpty()) return 0;

                char top = st.pop();

                // Check if closing bracket matches opening bracket
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return 0;
                }
            }
        }

        // At end, stack must be empty
        return st.isEmpty() ? 1 : 0;
    }
}
