import java.util.Scanner;

public class Divisibility_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int moves = 0;
            while (a % b != 0) {
                a++;
                moves++;
            }

            System.out.println(moves);
        }

        scanner.close();
    }
}
