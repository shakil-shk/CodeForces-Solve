import java.util.Scanner;

public class Beautiful_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0, y = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        int moves = Math.abs(x - 2) + Math.abs(y - 2);
        System.out.println(moves);
    }
}
