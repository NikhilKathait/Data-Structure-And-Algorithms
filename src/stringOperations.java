public class stringOperations {
    public String solve(String A) {
        String doubled = A + A;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < doubled.length(); i++)
        {
            char ch = doubled.charAt(i);

            if(Character.isUpperCase(ch)) {
                continue;
            }

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                sb.append('#');
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
