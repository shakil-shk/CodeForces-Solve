import java.util.Scanner;

public class Tram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of stops
        int currentPassengers = 0;
        int maxCapacity = 0;

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            currentPassengers -= a;
            currentPassengers += b;

            if (currentPassengers > maxCapacity) {
                maxCapacity = currentPassengers;
            }
        }

        System.out.println(maxCapacity);
    }
}
