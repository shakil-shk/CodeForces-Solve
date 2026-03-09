
import java.io.*;
import java.util.*;

public class DivisiveBattle {

    static final int MAX_VAL = 1_000_001;
    static int[] spf = new int[MAX_VAL];

    static void buildSieve() {
        for (int i = 2; i < MAX_VAL; i++) {
            if (spf[i] == 0) {
                for (int j = i; j < MAX_VAL; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    static boolean isPrimePower(int x) {
        if (x <= 1) {
            return true;
        }
        int p = spf[x];
        while (x > 1) {
            if (x % p != 0) {
                return false;
            }
            x /= p;
        }
        return true;
    }

    static int basePrime(int x) {
        if (x <= 1) {
            return 1;
        }
        return spf[x];
    }

    static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        buildSieve();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(solve(a, n) ? "Alice" : "Bob").append('\n');
        }
        System.out.print(sb);
    }

    static boolean solve(int[] a, int n) {
        if (isSorted(a)) {
            return false;
        }

        for (int x : a) {
            if (!isPrimePower(x)) {
                return true;
            }
        }

        int[] bases = new int[n];
        for (int i = 0; i < n; i++) {
            bases[i] = basePrime(a[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (bases[i] > bases[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
