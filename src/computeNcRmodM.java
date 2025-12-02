import java.util.*;

public class computeNcRmodM {
    public int solve(int A, int B, int C) {
        if (B < 0 || B > A) return 0;
        if (C == 1) return 0;

        // factorize C into prime powers
        List<long[]> factors = factorize(C);

        long[] rem = new long[factors.size()];
        long[] mod = new long[factors.size()];

        for (int i = 0; i < factors.size(); i++) {
            int p = (int) factors.get(i)[0];
            int pk = (int) factors.get(i)[1];
            rem[i] = nCrModPrimePower(A, B, p, pk);
            mod[i] = pk;
        }

        return (int) (crtCombine(rem, mod) % C);
    }

    // factorize m into [p, p^e]
    private List<long[]> factorize(int m) {
        List<long[]> res = new ArrayList<>();
        int mm = m;
        for (int p = 2; p * p <= mm; p++) {
            if (mm % p == 0) {
                int pk = 1;
                while (mm % p == 0) { mm /= p; pk *= p; }
                res.add(new long[]{p, pk});
            }
        }
        if (mm > 1) res.add(new long[]{mm, mm});
        return res;
    }

    // compute nCr mod p^k
    private long nCrModPrimePower(int n, int r, int p, int pk) {
        if (r == 0) return 1 % pk;

        // exponent of p in nCr
        int exp = countPInFactorial(n, p)
                - countPInFactorial(r, p)
                - countPInFactorial(n - r, p);

        long num = 1;
        for (int i = n - r + 1; i <= n; i++) {
            int x = i;
            while (x % p == 0) x /= p;
            num = (num * (x % pk)) % pk;
        }

        long den = 1;
        for (int i = 1; i <= r; i++) {
            int x = i;
            while (x % p == 0) x /= p;
            den = (den * (x % pk)) % pk;
        }

        int powerInMod = 0;
        int temp = pk;
        while (temp % p == 0) {
            powerInMod++;
            temp /= p;
        }

        if (exp >= powerInMod) return 0;

        long invDen = modInverse(den, pk);
        long res = num % pk;
        res = (res * invDen) % pk;
        res = (res * modPow(p, exp, pk)) % pk;

        return (res + pk) % pk;
    }

    private int countPInFactorial(int n, int p) {
        int cnt = 0;
        while (n > 0) {
            n /= p;
            cnt += n;
        }
        return cnt;
    }

    private long crtCombine(long[] rem, long[] mod) {
        long M = 1;
        for (long v : mod) M *= v;

        long res = 0;
        for (int i = 0; i < rem.length; i++) {
            long mi = mod[i];
            long Mi = M / mi;
            long inv = modInverse(Mi % mi, mi);
            res = (res + (rem[i] * Mi % M) * inv) % M;
        }

        return (res + M) % M;
    }

    private long modPow(long a, long e, long mod) {
        a %= mod;
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            e >>= 1;
        }
        return res;
    }

    private long modInverse(long a, long mod) {
        a = (a % mod + mod) % mod;
        long[] eg = extGcd(a, mod);
        long g = eg[0], x = eg[1];
        if (g != 1) return -1;
        long inv = x % mod;
        if (inv < 0) inv += mod;
        return inv;
    }

    private long[] extGcd(long a, long b) {
        if (b == 0) return new long[]{a, 1, 0};
        long[] t = extGcd(b, a % b);
        long g = t[0], x1 = t[1], y1 = t[2];
        long x = y1;
        long y = x1 - (a / b) * y1;
        return new long[]{g, x, y};
    }
}
