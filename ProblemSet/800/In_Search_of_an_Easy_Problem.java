import java.util.Scanner;

public class In_Search_of_an_Easy_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        boolean isHard = false;

        for (int i = 0; i < n; i++) {
            int opinion = scanner.nextInt();
            if (opinion == 1) {
                isHard = true;
            }
        }

        if (isHard) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }

        scanner.close();
    }
}
