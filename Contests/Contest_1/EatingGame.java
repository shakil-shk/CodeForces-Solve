
import java.util.*;

public class EatingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Set<Integer> winners = new HashSet<>();
            for (int start = 0; start < n; start++) {
                int[] dishes = a.clone();
                int current = start;
                int lastEater = -1;

                int totalDishes = 0;
                for (int d : dishes) {
                    totalDishes += d;
                }

                for (int eaten = 0; eaten < totalDishes;) {
                    if (dishes[current] > 0) {
                        dishes[current]--;
                        lastEater = current;
                        eaten++;
                    }
                    current = (current + 1) % n;
                }

                winners.add(lastEater + 1);
            }

            System.out.println(winners.size());
        }
    }
}
