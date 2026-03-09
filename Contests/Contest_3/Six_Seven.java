
import java.util.*;

public class Six_Seven {

    static boolean isSpecial(long x) {

        int v2 = 0, v3 = 0, v7 = 0;
        long t = x;

        while (t % 2 == 0) {
            v2++;
            t /= 2;
        }

        t = x;
        while (t % 3 == 0) {
            v3++;
            t /= 3;
        }

        t = x;
        while (t % 7 == 0) {
            v7++;
            t /= 7;
        }

        return Math.min(v2, v3) > v7;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long maxNeed = 0;

            boolean possible = true;

            for (int i = 0; i < n; i++) {

                boolean found = false;

                for (int d = 0; d <= 200; d++) {

                    if (isSpecial(a[i] + d)) {

                        maxNeed = Math.max(maxNeed, d);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println(-1);
                continue;
            }

            for (int i = 0; i < n; i++) {
                if (!isSpecial(a[i] + maxNeed)) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println(maxNeed); 
            }else {
                System.out.println(-1);
            }
        }
    }
}
