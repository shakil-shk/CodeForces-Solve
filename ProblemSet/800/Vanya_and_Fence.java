import java.util.Scanner;

public class Vanya_and_Fence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int h = scanner.nextInt();

        int width = 0;

        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();

            if (height > h) {
                width += 2;
            } else {
                width += 1;
            }
        }

        System.out.println(width);
    }
}
