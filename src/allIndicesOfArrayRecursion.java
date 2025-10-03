public class allIndicesOfArrayRecursion {
    public int[] allIndices(int[] A, int B) {
        return targetIdx(A,B,0);
    }

    public int[] targetIdx(int[] A, int B, int idx) {
        // Base case: if reached end of array
        if(idx == A.length) {
            return new int[0];   // empty array
        }

        int[] rest = targetIdx(A, B, idx + 1);

        if(A[idx] == B) {
            // Create new array with +1 size
            int[] ans = new int[rest.length + 1];
            ans[0] = idx;   // add current index at front
            // copy rest elements
            for(int i = 0; i < rest.length; i++) {
                ans[i+1] = rest[i];
            }
            return ans;
        } else {
            // just return rest
            return rest;
        }
    }
}
