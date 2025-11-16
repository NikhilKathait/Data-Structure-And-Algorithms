import java.util.*;

public class nearestSmallerElementStack {
    public int[] prevSmaller(int[] A) {

        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Pop all elements >= A[i] since they cannot be the previous smaller
            while (!st.isEmpty() && st.peek() >= A[i]) {
                st.pop();
            }

            // If stack empty, no smaller element on left
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            // Push current element for future checks
            st.push(A[i]);
        }

        return ans;
    }
}
