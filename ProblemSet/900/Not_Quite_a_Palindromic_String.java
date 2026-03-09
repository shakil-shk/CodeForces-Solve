
import java.util.*;

public class Not_Quite_a_Palindromic_String {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int cnt0 = 0, cnt1 = 0;

            for (char c : s.toCharArray()) {
                if (c == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }

            int maxPairs = (cnt0 / 2) + (cnt1 / 2);

            if (k <= maxPairs) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
