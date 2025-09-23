import java.util.*;

public class addOneToInteger {
    public int[] plusOne(int[] A) {
        int N = A.length;

        // Starting from last digit
        int carry = 1;
        for(int i = N - 1; i>=0; i--) {
            int sum = A[i] + carry;
            A[i] = sum % 10;
            carry = sum / 10;
        }

        // If carry is still left, add it to the front
        if(carry > 0) {
            int[] result = new int[N + 1];
            result[0] = carry;
            for(int i = 0; i< N; i++) {
                result[i + 1] = A[i];
            }

            A = result;
        }

        // Remove leading zeros (if any in input)
        int idx = 0;
        while(idx < A.length - 1 && A[idx] == 0) {
            idx++;
        }

        return Arrays.copyOfRange(A, idx, A.length);
    }
}
