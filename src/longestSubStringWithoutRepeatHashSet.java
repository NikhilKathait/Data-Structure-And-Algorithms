import java.util.*;

public class longestSubStringWithoutRepeatHashSet {
    public int lengthOfLongestSubstring(String A) {
        int N = A.length();
        int start = 0, end = 0;
        int length = 0;

        HashSet<Character> hs = new HashSet<>();

        while (end < N) {
            char ch = A.charAt(end);

            while ( start < end && hs.contains(ch)) {
                hs.remove(A.charAt(start));
                start++;
            }

            hs.add(ch);
            length = Math.max(length, end - start + 1);
            end++;
        }

        return length;
    }
}
