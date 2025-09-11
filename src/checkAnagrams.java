public class checkAnagrams {
    public int solve(String A, String B) {
        if(A.length() != B.length()) {
            return 0;
        }

        int[] freq = new int[26];

        for(int i = 0; i < A.length(); i++) {
            freq[A.charAt(i) - 'a']++;
        }

        for(int i = 0; i < B.length(); i++) {
            freq[B.charAt(i) - 'a']--;
        }

        for(int f : freq) {
            if(f != 0) {
                return 0;
            }
        }

        return 1;
    }
}
