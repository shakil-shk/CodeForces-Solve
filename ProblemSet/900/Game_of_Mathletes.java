
import java.util.*;

public class Game_of_Mathletes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            int score = 0;

            for (int x : new HashSet<>(freq.keySet())) {

                int y = k - x;

                if (!freq.containsKey(x)) {
                    continue;
                }

                if (x == y) {
                    score += freq.get(x) / 2;
                    freq.remove(x);
                } else if (freq.containsKey(y)) {

                    int pairs = Math.min(freq.get(x), freq.get(y));
                    score += pairs;

                    freq.remove(x);
                    freq.remove(y);
                }
            }

            System.out.println(score);
        }
    }
}
