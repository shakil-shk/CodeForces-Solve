import java.util.Scanner;

public class Petya_And_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.nextLine().trim();
        String s2 = scanner.nextLine().trim();

        String s1Lower = s1.toLowerCase();
        String s2Lower = s2.toLowerCase();

        int result = s1Lower.compareTo(s2Lower);

        if (result < 0) {
            System.out.println("-1");
        } else if (result > 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        scanner.close();
    }
}
