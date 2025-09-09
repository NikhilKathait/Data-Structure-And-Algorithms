public class toggleCaseStrings {
    public String solve(String A) {
        int N = A.length();
        char[] strArray = new char[N];

        for(int i = 0; i < N; i++)
        {
            char ch = A.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                strArray[i] = (char)(ch - 'a' + 'A');
            }
            else {
                strArray[i] = (char)(ch - 'A' + 'a');
            }
        }

        return new String(strArray);
    }
}
