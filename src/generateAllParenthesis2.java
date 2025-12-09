import java.util.*;

public class generateAllParenthesis2 {
    public String[] generateParenthesis(int A) {
        List<String> result = new ArrayList<>();

        parenthesis(result, "", 0, 0, A);

        // convert to sorted array
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void parenthesis(List<String> result, String current, int open, int close, int A) {
        // If current string is complete
        if (current.length() == 2 * A) {
            result.add(current);
            return;
        }

        // Add '(' if possible
        if (open < A) {
            parenthesis(result, current + "(", open + 1, close, A);
        }

        // Add ')' only if it won't break balance
        if (close < open) {
            parenthesis(result, current + ")", open, close + 1, A);
        }
    }
}
