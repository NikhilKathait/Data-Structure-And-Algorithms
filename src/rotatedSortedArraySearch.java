public class rotatedSortedArraySearch {
    public int search(final int[] A, int B) {
        int N = A.length;

        int low = 0, high = N - 1;

        while (low <= high) {
            int mid = (low + high)/2;

            if (A[mid] == B) return mid;

            else if (A[low] <= A[mid]) {
                if (A[low] <= B && B < A[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            else {
                if (A[mid] < B && B <= A[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }
}
