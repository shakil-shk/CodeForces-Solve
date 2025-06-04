import java.util.Scanner;
public class Team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int participants;
        int count =0;
        participants = scanner.nextInt();

        for (int i = 0; i < participants; i++){
          int petya = scanner.nextInt();
          int vasya = scanner.nextInt();
          int tonya = scanner.nextInt();

          if (petya + vasya + tonya >= 2){
              count++;
          }
        }
        System.out.println(count);
    }
}
