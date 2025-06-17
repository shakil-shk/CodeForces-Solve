import java.util.Scanner;

public class Anton_and_Danik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int antonWins = 0;
        int danikWins = 0;

        for (int i = 0; i < s.length(); i++) {
            char result = s.charAt(i);
            if (result == 'A') {
                antonWins++;
            } else if (result == 'D') {
                danikWins++;
            }
        }

        if (antonWins > danikWins) {
            System.out.println("Anton");
        } else if (danikWins > antonWins) {
            System.out.println("Danik");
        } else {
            System.out.println("Friendship");
        }

        scanner.close();
    }
}
