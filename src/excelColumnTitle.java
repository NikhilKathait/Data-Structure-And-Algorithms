public class excelColumnTitle {
    public String convertToTitle(int A) {
        StringBuilder sb = new StringBuilder();

        while (A>0) {
            A--;
            int rem = A % 26;
            A = A/26;

            char ch = (char) ('A' + rem);
            sb.append(ch);
        }

        return sb.reverse().toString();
    }
}
