public class longestIncreasingSubsequenceDSAContest {
    public static int lengthOfLIS(int[] A) {

        int[] tails = new int[A.length];
        int size = 0;

        for (int num : A) {

            int left = 0, right = size;

            while (left < right) {

                int mid = (left + right) / 2;

                if (tails[mid] < num)
                    left = mid + 1;
                else
                    right = mid;
            }

            tails[left] = num;

            if (left == size)
                size++;
        }

        return size;
    }
}
