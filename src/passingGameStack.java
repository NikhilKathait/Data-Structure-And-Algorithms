import java.util.*;

public class passingGameStack {
    public int solve(int A, int B, int[] C) {
        Stack<Integer> st = new Stack<>();
        st.push(B);  // initial player

        for (int i = 0; i < A; i++) {

            if (C[i] == 0) {
                // back pass, remove current player
                st.pop();
            } else {
                // forward pass, go to new player
                st.push(C[i]);
            }
        }

        return st.peek();
    }
}
