import java.util.*;

public class evaluateExpressionStack {
    public int evalRPN(String[] A) {
        Stack<Integer> st = new Stack<>();

        for (String s : A) {

            // If s is an operator
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

                int b = st.pop();  // second operand
                int a = st.pop();  // first operand

                int result = 0;

                switch (s) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;   // order matters
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;   // integer division
                        break;
                }

                st.push(result);

            } else {
                // Otherwise it's a number
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }
}
