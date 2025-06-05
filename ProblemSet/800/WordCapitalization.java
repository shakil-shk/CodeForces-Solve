import java.util.Scanner;

public class WordCapitalization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        String result = word.substring(0, 1).toUpperCase() + word.substring(1);

        System.out.println(result);

           /* Or this is more detailed solution for this problem
                Scanner sc = new Scanner(System.in);
                String word = sc.nextLine();

                char firstChar = word.charAt(0);
                char upperFirstChar = Character.toUpperCase(firstChar);
                String rest = word.substring(1);

                String result = upperFirstChar + rest;
                System.out.println(result);
            */

    }
}

