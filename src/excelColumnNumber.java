public class excelColumnNumber {
    public int titleToNumber(String A) {
        int column = 0;

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            int val = ch - 'A' + 1;     // Convert char to 1 to 26
            column = column * 26 + val;
        }

        return column;
    }
}
