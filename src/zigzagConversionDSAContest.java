public class zigzagConversionDSAContest {
    public String convert(String A, int B) {

        if (B == 1 || A.length() <= B) {
            return A;
        }

        StringBuilder[] rows = new StringBuilder[B];
        for (int i = 0; i < B; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : A.toCharArray()) {

            rows[currentRow].append(c);

            // Change direction at top or bottom
            if (currentRow == 0 || currentRow == B - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < B; i++) {
            result.append(rows[i]);
        }

        return result.toString();
    }
}
