
import java.util.*;

public class Shifting_Stacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] h = new long[n];
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextLong();
            }

            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (h[i] < i) {
                    possible = false;
                    break;
                }
                if (i < n - 1) {
                    h[i + 1] += h[i] - i;

                }
            }

            System.out.println(possible ? "YES" : "NO");
        }
    }
}
