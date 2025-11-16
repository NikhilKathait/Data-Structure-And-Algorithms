import java.util.*;

public class sortStackUsingAnotherStack {
    public int[] solve(int[] A) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> sorted = new Stack<>();

        for (int x : A) st.push(x);

        while (!st.isEmpty()) {
            int temp = st.pop();

            while (!sorted.isEmpty() && sorted.peek() > temp) {
                st.push(sorted.pop());
            }

            sorted.push(temp);
        }

        int n = A.length;
        int[] ans = new int[n];

        // Extract from sorted stack to array (ascending order)
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = sorted.pop();
        }

        return ans;
    }
}
