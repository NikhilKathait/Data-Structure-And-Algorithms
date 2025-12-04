public class pascalTriangle {
    public int[][] solve(int A) {
        int[][] result = new int[A][A];

        for (int i = 0; i < A; i++) {
            result[i][0] = 1;           // first element always 1

            for (int j = 1; j <= i; j++) {
                // Pascal rule: nCk = (n-1Ck-1 + n-1Ck)
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
        }

        return result;
    }
}
