import java.util.*;

public class uniqueLetterUsingQueue {
    public String solve(String A) {
        int[] freq = new int[26];          // frequency of each letter
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char c : A.toCharArray()) {

            // Step 1: increment frequency
            freq[c - 'a']++;

            // Step 2: push into queue
            q.add(c);

            // Step 3: remove all repeating characters from front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // Step 4: check first non-repeating
            if (q.isEmpty()) {
                result.append('#');
            } else {
                result.append(q.peek());
            }
        }

        return result.toString();
    }
}
