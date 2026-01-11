import java.util.*;

public class assignMiceToHoles {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        // sort both lists
        Collections.sort(A);
        Collections.sort(B);

        int maxTime = 0;

        // assign ith mouse to ith hole
        for (int i = 0; i < A.size(); i++) {
            int time = Math.abs(A.get(i) - B.get(i));
            maxTime = Math.max(maxTime, time);
        }

        return maxTime;
    }
}
