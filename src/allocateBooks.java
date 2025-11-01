public class allocateBooks {
    public int books(int[] A, int B) {
        int N = A.length;
        // If students more than books, impossible
        if (B > N) return -1;

        // low = max pages in a single book, high = sum of all pages
        int low = 0;
        int high = 0;
        for (int num : A) {
            high += num;
            if (num > low) low = num;
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(A, mid, B) ==  true) {
                ans = mid;          // possible to allocate with max pages = mid
                high = mid - 1;     // try to find smaller maximum
            }
            else {
                low = mid + 1;      // need larger capacity
            }
        }

        return ans;
    }

    private boolean canAllocate(int[] A, int maxPages, int B) {
        int students = 1;
        int currentSum = 0;

        for (int pages : A) {
            currentSum += pages;
            if (currentSum > maxPages) {
                // allocate to next student
                students++;
                currentSum = pages; // current book starts the next student
                if (students > B) return false; // need more than B students
            }
        }

        return true;
    }
}
