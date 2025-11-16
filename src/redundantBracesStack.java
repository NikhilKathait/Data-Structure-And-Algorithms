import java.util.*;

public class redundantBracesStack {
    public int braces(String A) {
        Stack<Character> st = new Stack<>();

        for (char c : A.toCharArray()) {

            // Push everything except closing bracket
            if (c != ')') {
                st.push(c);
            } else {

                // At encountering ')', check content inside
                boolean hasOperator = false;

                while (!st.isEmpty() && st.peek() != '(') {
                    char top = st.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // Pop the '('
                if (!st.isEmpty()) st.pop();

                // If no operator inside then redundant
                if (!hasOperator) return 1;
            }
        }

        return 0;
    }
}
