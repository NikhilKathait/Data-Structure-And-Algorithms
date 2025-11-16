import java.util.*;

public class infixToPostdfixStack {
    public String solve(String A) {
        StringBuilder output = new StringBuilder();    // result
        Stack<Character> st = new Stack<>();           // operator stack

        for (char ch : A.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);                     // add operand
            } else if (ch == '(') {
                st.push(ch);                           // push '('
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    output.append(st.pop());           // pop till '('
                st.pop();                              // remove '('
            } else {                                   // operator
                while (!st.isEmpty() && st.peek() != '(' && shouldPop(st.peek(), ch))
                    output.append(st.pop());           // pop operators
                st.push(ch);                           // push operator
            }
        }

        while (!st.isEmpty())
            output.append(st.pop());                   // pop remaining

        return output.toString();
    }

    private int precedence(char c) {                   // operator precedence
        switch (c) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
        }
        return -1;
    }

    private boolean isRightAssociative(char c) {       // '^' check
        return c == '^';
    }

    private boolean shouldPop(char top, char current) { // pop rule
        int p1 = precedence(top);
        int p2 = precedence(current);
        if (p1 > p2) return true;                      // higher precedence
        if (p1 == p2) return true;                     // equal precedence (required)
        return false;
    }
}
