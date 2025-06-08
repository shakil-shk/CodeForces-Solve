import java.util.Scanner;

public class Required_Remainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int n = scanner.nextInt();

            int k = n - ((n - y) % x);
            System.out.println(k);
        }

        scanner.close();
    }
}
