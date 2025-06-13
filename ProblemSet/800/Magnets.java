import java.util.Scanner;

public class Magnets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int groups = 1;
        String prev = sc.nextLine();

        for (int i = 1; i < n; i++) {
            String curr = sc.nextLine();
            if (!curr.equals(prev)) {
                groups++;
            }
            prev = curr;
        }
        System.out.println(groups);
    }
}
