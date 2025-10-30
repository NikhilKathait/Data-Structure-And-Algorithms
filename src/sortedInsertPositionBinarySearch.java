public class sortedInsertPositionBinarySearch {
    public int searchInsert(int[] A, int B) {
        int N = A.length;
        int low = 0, high = N - 1, ans = N;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (A[mid] == B)
                return mid;
            else if (A[mid] > B) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
