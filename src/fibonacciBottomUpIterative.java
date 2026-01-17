import java.util.*;

public class fibonacciBottomUpIterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N <= 1) {
            System.out.print(N);
            return;
        }

        int prev2 = 0;  // f(0)
        int prev1 = 1;  // f(1)
        int curr = 0;

        for (int i = 2; i <= N; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        System.out.print(curr);
    }
}
