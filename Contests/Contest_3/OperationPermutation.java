import java.util.*;
import java.io.*;

public class OperationPermutation {

    static final long MOD = 1_000_000_007L;

    static long pow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    static long modinv(long a) {
        return pow(a % MOD, MOD - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken()) % MOD;

            String[] tokens = br.readLine().trim().split("\\s+");

            long[] mults = new long[n];
            long[] adds = new long[n];
            int km = 0, ka = 0;

            for (String op : tokens) {
                char sym = op.charAt(0);
                long val = Long.parseLong(op.substring(1));
                if (sym == 'x') {
                    mults[km++] = val % MOD;
                } else if (sym == '/') {
                    mults[km++] = modinv(val);
                } else if (sym == '+') {
                    adds[ka++] = val % MOD;
                } else {
                    adds[ka++] = (MOD - val % MOD) % MOD;
                }
            }

            int k = km;
            long P = 1;
            for (int i = 0; i < k; i++) P = P * mults[i] % MOD;

            long sumAdds = 0;
            for (int i = 0; i < ka; i++) sumAdds = (sumAdds + adds[i]) % MOD;

            if (k == 0) {
                sb.append((x + sumAdds) % MOD).append('\n');
                continue;
            }

            long[] e = new long[k + 1];
            e[0] = 1;
            for (int i = 0; i < k; i++) {
                long m = mults[i];
                for (int r = Math.min(i + 1, k); r >= 1; r--) {
                    e[r] = (e[r] + m * e[r - 1]) % MOD;
                }
            }

            long[] fact = new long[k + 2];
            long[] invFact = new long[k + 2];
            fact[0] = 1;
            for (int i = 1; i <= k + 1; i++) fact[i] = fact[i - 1] * i % MOD;
            invFact[k + 1] = modinv(fact[k + 1]);
            for (int i = k; i >= 0; i--) invFact[i] = invFact[i + 1] * (i + 1) % MOD;

            long Q = 0;
            for (int r = 0; r <= k; r++) {
                long ckr = fact[k] * invFact[r] % MOD * invFact[k - r] % MOD;
                Q = (Q + e[r] * modinv(ckr)) % MOD;
            }
            Q = Q * modinv(k + 1) % MOD;

            sb.append((x * P + sumAdds * Q) % MOD).append('\n');
        }

        System.out.print(sb);
    }
}