import java.util.*;

public class fractionalKnapsack {
    class pair {
        int val;
        int wt;
        pair(int v, int w) {
            val = v;
            wt = w;
        }
    }

    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        pair[] p = new pair[n];

        for (int i=0; i<n; i++) {
            p[i] = new pair(A[i], B[i]);
        }

        Arrays.sort(p, (x,y) -> {
            double r1 = (double) x.val/ x.wt;
            double r2 = (double) y.val / y.wt;

            return Double.compare(r2, r1);
        });

        double ans = 0.0;
        int cap = C;

        for (int i = 0; i<n && cap > 0; i++) {

            if (p[i].wt <= cap) {
                ans += p[i].val;
                cap -= p[i].wt;
            }
            else {
                ans += (double) p[i].val * cap / p[i].wt;
                break;
            }
        }

        return (int) Math.floor(ans * 100 + 1e-9);
    }
}
