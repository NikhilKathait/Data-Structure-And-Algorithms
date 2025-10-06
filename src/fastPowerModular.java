public class fastPowerModular {
    public int pow(int A, int B, int C) {

        if(A == 0) { return 0;}
        if(B == 0) { return 1%C;}

        long base = A % C;
        if (base < 0)
            base += C;

        long half = pow((int)base, B / 2, C);

        long res = (half % C * half % C) % C;

        if (B%2 == 0) {
            return (int) res;
        } else {
            return (int) ((res * base) % C);
        }
    }
}
