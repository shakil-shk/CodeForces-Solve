import java.util.Scanner;

public class Nearly_Lucky_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();

        int count = 0;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (c == '4' || c == '7') {
                count++;
            }
        }

        String countStr = Integer.toString(count);
        boolean isLucky = true;

        for (int i = 0; i < countStr.length(); i++) {
            char c = countStr.charAt(i);
            if (c != '4' && c != '7') {
                isLucky = false;
                break;
            }
        }

        if (isLucky && count > 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
