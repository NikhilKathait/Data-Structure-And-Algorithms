import java.util.*;

public class maxRectangleInBinaryMatrix {
    public int maximalRectangle(int[][] A) {
        int n = A.length, m = A[0].length;
        int[] height = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                height[j] = (A[i][j] == 0) ? 0 : height[j] + 1;
            }

            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] A) {
        int n = A.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : A[i]);

            while (!st.isEmpty() && h < A[st.peek()]) {
                int height = A[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();
                max = Math.max(max, height * (right - left - 1));
            }

            st.push(i);
        }

        return max;
    }
}
