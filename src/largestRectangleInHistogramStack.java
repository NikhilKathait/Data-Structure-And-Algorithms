import java.util.*;

public class largestRectangleInHistogramStack {
    public int largestRectangleArea(int[] A) {
        int N = A.length;
        int ans = 0;

        int[] left = nearestSmallerEleIdxOnLeft(A);
        int[] right = nearestSmallerEleIdxOnRight(A);

        for (int i = 0; i< N; i++) {
            int h = A[i];
            int width = right[i] - left[i] - 1;

            ans = Math.max(ans, h * width);
        }

        return ans;
    }

    public int[] nearestSmallerEleIdxOnLeft(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Pop all elements >= A[i] since they cannot be the previous smaller
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            // If stack empty, no smaller element on left
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            // Push current element for future checks
            st.push(i);
        }

        return ans;
    }

    public int[] nearestSmallerEleIdxOnRight(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Pop all elements >= A[i] since they cannot be the previous smaller
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }

            // If stack empty, no smaller element on left
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }

            // Push current element for future checks
            st.push(i);
        }

        return ans;
    }
}
