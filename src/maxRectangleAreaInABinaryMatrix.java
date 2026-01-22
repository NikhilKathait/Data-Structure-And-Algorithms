import java.util.*;

public class maxRectangleAreaInABinaryMatrix {
    public int maximalRectangle(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            // Build histogram
            for (int j = 0 ; j < n; j++) {
                if (A[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // Max rectangle in histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
