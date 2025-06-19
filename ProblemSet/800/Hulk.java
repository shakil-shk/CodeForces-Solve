import java.util.Scanner;

public class Hulk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder feeling = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                feeling.append("I hate");
            } else {
                feeling.append("I love");
            }
            if (i != n) {
                feeling.append(" that ");
            } else {
                feeling.append(" it");
            }
        }

        System.out.println(feeling.toString());
    }
}