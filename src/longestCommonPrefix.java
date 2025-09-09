public class longestCommonPrefix {
    public String longestCommonPrefix(String[] A) {
        if(A == null || A.length == 0) {
            return "";
        }

        String prefix = A[0];

        for(int i = 1; i<A.length; i++) {
            while(!A[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
