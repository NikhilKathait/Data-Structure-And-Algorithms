public class searchForARangeBinarySearch {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] A, int B) {
        int[] result = new int[2];
        result[0] = findFirst(A, B);
        result[1] = findLast(A, B);
        return result;
    }

    private int findFirst(int[] A, int B) {
        int low = 0, high = A.length - 1, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == B) {
                ans = mid;          // Found B
                high = mid - 1;     // move left to find first
            }
            else if (A[mid] < B) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private int findLast(int[] A, int B) {
        int low = 0, high = A.length - 1, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid] == B) {
                ans = mid;          // Found B
                low = mid + 1;      // move right to find last
            }
            else if (A[mid] < B) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
