import java.util.Scanner;
public class BitPlusPLus{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            scanner.nextLine();
            int result = 0;

            for (int i = 0; i < number; i++) {
                String operation = scanner.nextLine();
                if (operation.contains("++")) {
                    result++;
                } else if (operation.contains("--")) {
                    result--;
                }
            }
            System.out.println(result);
        }
    }
