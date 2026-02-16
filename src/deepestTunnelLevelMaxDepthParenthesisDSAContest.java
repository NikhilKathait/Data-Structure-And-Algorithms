public class deepestTunnelLevelMaxDepthParenthesisDSAContest {
    public static int maxDepth(String A) {

        int depth = 0;
        int maxDepth = 0;

        for (int i = 0; i < A.length(); i++) {

            char c = A.charAt(i);

            if (c == '(') {

                depth++;
                maxDepth = Math.max(maxDepth, depth);

            } else if (c == ')') {

                depth--;
            }
        }

        return maxDepth;
    }
}
