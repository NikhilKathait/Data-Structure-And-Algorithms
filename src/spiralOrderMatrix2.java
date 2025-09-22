public class spiralOrderMatrix2 {
    public int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];

        int top = 0, bottom = A - 1;
        int left = 0, right = A - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            // Traverse left to right
            for (int j = left; j <= right; j++) {
                result[top][j] = num++;
            }
            top++;

            // Traverse top to bottom
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;

            // Traverse right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result[bottom][j] = num++;
                }
                bottom--;
            }

            // Traverse bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }

        return result;
    }
}
