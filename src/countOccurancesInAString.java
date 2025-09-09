public class countOccurancesInAString {
    public int solve(String A) {
        if(A == null  || A.length() == 0) return 0;

        int N = A.length();
        int count = 0;

        for(int i = 0; i< N-2; i++)
        {
            if(A.substring(i, i+3).equals("bob")) {
                count++;
            }
        }
        return count;
    }
}
