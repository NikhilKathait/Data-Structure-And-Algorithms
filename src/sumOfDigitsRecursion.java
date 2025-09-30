public class sumOfDigitsRecursion {
    public int solve(int A) {
        // Base case: if A is 0, sum is 0
        if(A == 0) return 0;

        // Recursive case: sum of last digit + sum of remaining digits
        return (A % 10) + solve(A / 10);
    }
}
