import java.util.Scanner;

public class UltraFastMathematician {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result.append('0');
            } else {
                result.append('1');
            }
        }

        System.out.println(result.toString());
    }
}
