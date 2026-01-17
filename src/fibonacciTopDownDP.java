import java.util.*;

public class fibonacciTopDownDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);

        int result = fibonacci(N, dp);

        System.out.print(result);
    }

    public static int fibonacci(int N, int[] dp) {
        if (N <= 1)
            return dp[N] = N;

        if (dp[N] != -1)
            return dp[N];

        int ans = fibonacci(N - 1, dp) + fibonacci(N - 2, dp);

        return dp[N] = ans;
    }
}
