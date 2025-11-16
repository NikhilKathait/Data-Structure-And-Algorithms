import java.util.*;

public class nextGreaterUsingStack {
    public int[] nextGreater(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Pop all elements <= current
            while (!st.isEmpty() && st.peek() <= A[i]) {
                st.pop();
            }

            // If stack empty then no greater element
            ans[i] = st.isEmpty() ? -1 : st.peek();

            // Push current element
            st.push(A[i]);
        }

        return ans;
    }
}
