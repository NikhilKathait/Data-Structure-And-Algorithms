public class minimumWindowSubstring {
    public String minWindow(String A, String B) {
        if (B.length() > A.length()) return "-1";

        int[] need = new int[128];

        for (int i = 0; i<B.length(); i++) {
            need[B.charAt(i)]++;
        }

        int[] window = new int[128];
        int required = B.length();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < A.length()) {

            char c = A.charAt(right);

            if (need[c] > 0) {
                window[c]++;
                if (window[c] <= need[c]) {
                    required--;
                }
            }
            right++;

            // try to shrink window
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char leftChar = A.charAt(left);
                if (need[leftChar] > 0) {
                    window[leftChar]--;

                    if (window[leftChar] < need[leftChar]) {
                        required++;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? "-1"
                : A.substring(start, start+minLen);
    }
}
