import java.util.Scanner;
public class Way_too_long_words {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String text;
byte number = scanner.nextByte();
scanner.nextLine();
for (byte i = 0; i < number; i++) {
    text = scanner.nextLine();
    if (text.length() > 10){
        char first = text.charAt(0);
        char last = text.charAt(text.length()-1);
        byte middle = (byte) (text.length()-2);
        System.out.printf("%c%d%c\n",first,middle,last);
    } else {
        System.out.println(text);
    }
}
  }
}

