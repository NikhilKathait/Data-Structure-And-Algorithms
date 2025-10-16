import java.util.*;

public class largestNumberComparator {
    public String largestNumber(int[] A) {
        // Convert int[] to List<String>
        String[] arr = new String[A.length];
        for (int i = 0; i< A.length; i++) {
            arr[i] = String.valueOf(A[i]);
        }

        // Custom comparator: decide order based on concatenated values
        Arrays.sort(arr, new Comparator<String> () {
            public int compare (String a, String b) {
                String XY = a + b;
                String YX = b + a;

                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        // If the largest number is "0", all are zeros
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the result
        StringBuilder ans = new StringBuilder();
        for (String s : arr) {
            ans.append(s);
        }

        return ans.toString();
    }
}
