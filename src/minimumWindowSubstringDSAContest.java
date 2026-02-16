public class minimumWindowSubstringDSAContest {
    public static String minWindow(String A, String B) {

        if (A.length() < B.length()) return "";

        int[] freq = new int[256];

        // store frequency of B
        for (char c : B.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int required = B.length();

        for (int right = 0; right < A.length(); right++) {

            char rc = A.charAt(right);

            // if required char found
            if (freq[rc] > 0) {
                required--;
            }

            freq[rc]--;

            // valid window
            while (required == 0) {

                int windowLen = right - left + 1;

                if (windowLen < minLen) {
                    minLen = windowLen;
                    start = left;
                }

                char lc = A.charAt(left);

                freq[lc]++;

                if (freq[lc] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : A.substring(start, start + minLen);
    }
}
