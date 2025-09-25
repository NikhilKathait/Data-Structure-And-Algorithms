public class singleNumberIII {
    public int[] solve(int[] A) {
        int val = 0;

        // XOR of all numbers, gives xor of the two unique elements
        for (int num : A) {
            val ^= num;
        }

        // Find the rightmost set bit in val
        int idx = -1;
        for(int i = 0; i < 32; i++) {
            if((val & (1 << i)) != 0) {
                idx = i;
                break;
            }
        }

        // Partition numbers into 2 groups based on idx-th bit
        int set = 0, unset = 0;
        int N = A.length;
        for(int num : A) {
            if((num & (1 << idx)) != 0)
                set ^= num;
            else
                unset ^= num;
        }

        // Put in ascending order
        int[] result = new int[2];
        if (set < unset) {
            result[0] = set;
            result[1] = unset;
        } else {
            result[0] = unset;
            result[1] = set;
        }

        return result;
    }
}
