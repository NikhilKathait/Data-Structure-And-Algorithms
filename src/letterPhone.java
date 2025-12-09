import java.util.*;

public class letterPhone {
    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> result = new ArrayList<>();
        if (A == null || A.length() == 0) return result;

        // digit -> letters mapping (telephone)
        String[] mapping = new String[10];
        mapping[0] = "0";
        mapping[1] = "1";
        mapping[2] = "abc";
        mapping[3] = "def";
        mapping[4] = "ghi";
        mapping[5] = "jkl";
        mapping[6] = "mno";
        mapping[7] = "pqrs";
        mapping[8] = "tuv";
        mapping[9] = "wxyz";

        StringBuilder sb = new StringBuilder();
        backtrack(A, 0, sb, result, mapping);

        // Ensure lexicographic order
        Collections.sort(result);
        return result;
    }

    private void backtrack(String digits, int idx, StringBuilder sb,
                           ArrayList<String> result, String[] mapping) {

        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char ch = digits.charAt(idx);
        if (ch < '0' || ch > '9') return; // invalid characters

        String letters = mapping[ch - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(digits, idx + 1, sb, result, mapping);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
