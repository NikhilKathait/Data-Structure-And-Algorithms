public class checkPalindromeUsingRecursion {
    public int solve(String A) {
        int N = A.length();

        return palindrome(A, 0, N-1);
    }

    public int palindrome(String A, int start, int end) {
        // Base case: crossed the middle then it is a palindrome
        if (start >= end) {
            return 1;
        }

        // If mismatch then not a palindrome
        if (A.charAt(start) != A.charAt(end)) {
            return 0;
        }

        // Recurse inwards
        return palindrome(A, start + 1, end - 1);
    }
}
