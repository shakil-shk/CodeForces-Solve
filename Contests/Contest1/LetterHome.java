import java.util.Scanner;

public class LetterHome {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // this t as number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }
            int min_x = x[0];
            int max_x = x[n - 1];
            if (s <= min_x) {
                System.out.println(max_x - s);
            } else if (s >= max_x) {
                System.out.println(s - min_x);
            } else {
                System.out.println(max_x - min_x + Math.min(s - min_x, max_x - s));
            }
        }
        scanner.close();
    }
}